package com.lgy.common.disruptor;

import com.lmax.disruptor.dsl.Disruptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author LGy
 * @Date 2019/12/30
 * @Description DisruptorUtil
 */
public abstract class AbstractDisruptorUtil<T> implements DisposableBean, InitializingBean {

    protected static Logger logger = LoggerFactory.getLogger(AbstractDisruptorUtil.class);

    protected Disruptor<T> disruptor;

    protected static final int RING_BUFFER_SIZE = 1024 * 1024;

    public Disruptor<T> getDisruptor() {
        return disruptor;
    }

    @Override
    public void destroy() {
        disruptor.shutdown();
        logger.info("disruptor shutdown");
    }

}
