package com.lgy.common.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Description 内容消费者
 * @Author LGy
 * @Date 2019/12/27
 */
public abstract class AbstractHandler<T> implements EventHandler<T>, WorkHandler<T> {

    protected static Logger logger = LoggerFactory.getLogger(AbstractHandler.class);

    @Override
    public void onEvent(T event, long sequence, boolean endOfBatch) throws Exception {
        onEvent(event);
    }
}