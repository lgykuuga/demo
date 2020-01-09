package com.lgy.common.disruptor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * lmax.disruptor 高效队列处理模板. 支持初始队列，即在init()前进行发布。
 *
 * 调用init()时才真正启动线程开始处理 系统退出自动清理资源.

 */
public abstract class BaseQueueHelper<D, E extends ValueWrapper<D>, H extends WorkHandler<E>> {

    /**
     * 记录所有的队列，系统退出时统一清理资源
     */
    private static List<BaseQueueHelper> queueHelperList = new ArrayList<>();
    /**
     * Disruptor 对象
     */
    private Disruptor<E> disruptor;
    /**
     * RingBuffer
     */
    private RingBuffer<E> ringBuffer;
    /**
     * initQueue
     */
    private List<D> initQueue = new ArrayList<D>();

    /**
     * 队列大小
     *
     * @return 队列长度，必须是2的幂
     */
    protected abstract int getQueueSize();

    /**
     * 事件工厂
     *
     * @return EventFactory
     */
    protected abstract EventFactory<E> eventFactory();

    /**
     * 事件消费者
     *
     * @return WorkHandler[]
     */
    protected abstract WorkHandler[] getHandler();

    /**
     * 初始化
     */
    public void init() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("DisruptorThreadPool").build();
        disruptor = new Disruptor<E>(eventFactory(), getQueueSize(), namedThreadFactory, ProducerType.SINGLE, getStrategy());
        disruptor.setDefaultExceptionHandler(new MyHandlerException());
        disruptor.handleEventsWithWorkerPool(getHandler());
        ringBuffer = disruptor.start();

        //初始化数据发布
        for (D data : initQueue) {
            ringBuffer.publishEvent((event, sequence, data1) -> event.setValue(data1), data);
        }

        //加入资源清理钩子
        synchronized (queueHelperList) {
            if (queueHelperList.isEmpty()) {
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    for (BaseQueueHelper baseQueueHelper : queueHelperList) {
                        baseQueueHelper.shutdown();
                    }
                }));
            }
            queueHelperList.add(this);
        }
    }

    /**
     * 如果要改变线程执行优先级，override此策略. YieldingWaitStrategy会提高响应并在闲时占用70%以上CPU，
     * 慎用SleepingWaitStrategy会降低响应更减少CPU占用，用于日志等场景.
     *
     * @return WaitStrategy
     */
    protected abstract WaitStrategy getStrategy();

    /**
     * 插入队列消息，支持在对象init前插入队列，则在队列建立时立即发布到队列处理.
     */
    public synchronized void publishEvent(D data) {
        if (ringBuffer == null) {
            initQueue.add(data);
            return;
        }
        ringBuffer.publishEvent((event, sequence, data1) -> event.setValue(data1), data);
    }

    /**
     * 关闭队列
     */
    public void shutdown() {
        disruptor.shutdown();
    }
}