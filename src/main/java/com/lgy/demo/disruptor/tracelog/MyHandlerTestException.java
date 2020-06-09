package com.lgy.demo.disruptor.tracelog;

import com.lmax.disruptor.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/9 14:17
 **/
public class MyHandlerTestException implements ExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(MyHandlerTestException.class);

    /**
     * (non-Javadoc) 运行过程中发生时的异常
     *
     * @see
     * ExceptionHandler#handleEventException(Throwable
     * , long, Object)
     */
    @Override
    public void handleEventException(Throwable ex, long sequence, Object event) {
        ex.printStackTrace();
        logger.error("Test!!!!!!!!!!!!!");
    }

    /**
     * (non-Javadoc) 启动时的异常
     *
     * @see
     * ExceptionHandler#handleOnStartException(Throwable)
     */
    @Override
    public void handleOnStartException(Throwable ex) {
        logger.error("start disruptor error ==[{}]!", ex.getMessage());
    }

    /*
     * (non-Javadoc) 关闭时的异常
     *
     * @see
     * com.lmax.disruptor.ExceptionHandler#handleOnShutdownException(java.lang
     * .Throwable)
     */
    @Override
    public void handleOnShutdownException(Throwable ex) {
        logger.error("shutdown disruptor error ==[{}]!", ex.getMessage());
    }

}
