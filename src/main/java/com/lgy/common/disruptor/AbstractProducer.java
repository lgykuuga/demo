package com.lgy.common.disruptor;

import com.lmax.disruptor.RingBuffer;
import org.springframework.beans.BeanUtils;

/**
 * @Description Producer
 * @Author LGy
 * @Date 2020/1/3 16:42
 **/
public abstract class AbstractProducer<T> {

    protected RingBuffer<T> ringBuffer;

    public AbstractProducer(RingBuffer<T> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(T t) {

        long sequence = ringBuffer.next();
        try {
            T t1 = ringBuffer.get(sequence);
            BeanUtils.copyProperties(t, t1);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
