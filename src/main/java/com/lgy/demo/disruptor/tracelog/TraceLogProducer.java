package com.lgy.demo.disruptor.tracelog;

import com.lgy.common.disruptor.AbstractProducer;
import com.lmax.disruptor.RingBuffer;

/**
 * @Description 日志消费者
 * @Author LGy
 * @Date 2020/1/3 17:03
 **/
public class TraceLogProducer extends AbstractProducer<TraceLogEvent> {

    public TraceLogProducer(RingBuffer<TraceLogEvent> ringBuffer) {
        super(ringBuffer);
    }
}
