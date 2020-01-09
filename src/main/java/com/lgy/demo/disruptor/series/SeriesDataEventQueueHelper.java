package com.lgy.demo.disruptor.series;

import com.lgy.common.disruptor.BaseQueueHelper;
import com.lgy.common.disruptor.EventFactory;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/9 14:21
 **/
@Component
public class SeriesDataEventQueueHelper extends BaseQueueHelper<SeriesData, SeriesDataEvent, SeriesDataEventHandler> implements InitializingBean {

    private static final int QUEUE_SIZE = 1024;

    @Autowired
    private List<SeriesDataEventHandler> seriesDataEventHandler;


    @Override
    protected int getQueueSize() {
        return QUEUE_SIZE;
    }

    @Override
    protected com.lmax.disruptor.EventFactory eventFactory() {
        return new EventFactory();
    }

    @Override
    protected WorkHandler[] getHandler() {
        int size = seriesDataEventHandler.size();
        SeriesDataEventHandler[] paramEventHandlers = seriesDataEventHandler.toArray(new SeriesDataEventHandler[size]);
        return paramEventHandlers;
    }

    @Override
    protected WaitStrategy getStrategy() {
        return new BlockingWaitStrategy();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.init();
    }
}