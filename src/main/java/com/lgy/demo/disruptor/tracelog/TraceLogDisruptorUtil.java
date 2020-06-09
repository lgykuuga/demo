package com.lgy.demo.disruptor.tracelog;

import com.lgy.common.config.util.DaemonThreadFactory;
import com.lgy.common.disruptor.AbstractDisruptorUtil;
import com.lgy.common.disruptor.MyHandlerException;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ExceptionHandlerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/3 16:58
 **/
@Service
public class TraceLogDisruptorUtil extends AbstractDisruptorUtil<TraceLogEvent> {

    @Autowired
    TraceLogHandler traceLogHandler;

    @Autowired
    TraceLogHandlerTest traceLogHandlerTest;

    TraceLogProducer traceLogProducer;

    @Override
    public void afterPropertiesSet() throws Exception {

        disruptor = new Disruptor<>(
                TraceLogEvent::new,
                RING_BUFFER_SIZE,
                DaemonThreadFactory.INSTANCE
        );

//        //创建消费者组
//        disruptor.handleEventsWith(traceLogHandler);

//        //创建消费者组,多线程消费
//        int threadCount = 10;
//        TraceLogHandler[] traceLogHandlers = new TraceLogHandler[threadCount];
//        for (int i = 0; i < threadCount; i++) {
//            traceLogHandlers[i] = traceLogHandler;
//        }
//
//        disruptor.handleEventsWithWorkerPool(traceLogHandlers);
        disruptor.handleEventsWith(traceLogHandler);
        disruptor.handleEventsWith(traceLogHandlerTest);
//        ExceptionHandlerSetting<TraceLogEvent> exceptionsFor = disruptor.handleExceptionsFor(traceLogHandler);
//        exceptionsFor.with(new MyHandlerException());
//        ExceptionHandlerSetting<TraceLogEvent> testExceptionHandler = disruptor.handleExceptionsFor(traceLogHandlerTest);
//        testExceptionHandler.with(new MyHandlerTestException());

        disruptor.setDefaultExceptionHandler(new MyHandlerTestException());
        //启动disruptor
        disruptor.start();
        this.traceLogProducer = new TraceLogProducer(disruptor.getRingBuffer());
        logger.info("disruptor start");
    }

    public TraceLogProducer getTraceLogProducer() {
        return traceLogProducer;
    }
}
