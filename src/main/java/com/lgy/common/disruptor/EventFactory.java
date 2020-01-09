package com.lgy.common.disruptor;

import com.lgy.demo.disruptor.series.SeriesDataEvent;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/9 14:18
 **/
public class EventFactory implements com.lmax.disruptor.EventFactory<SeriesDataEvent> {


    @Override
    public SeriesDataEvent newInstance() {
        return new SeriesDataEvent();
    }
}
