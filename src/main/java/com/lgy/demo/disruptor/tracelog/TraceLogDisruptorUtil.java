package com.lgy.demo.disruptor.tracelog;

import com.lgy.common.config.util.DaemonThreadFactory;
import com.lgy.common.disruptor.AbstractDisruptorUtil;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/3 16:58
 **/
@Service
public class TraceLogDisruptorUtil extends AbstractDisruptorUtil<TraceLogEvent> {

    @Autowired
    TraceLogHandler traceLogHandler;

    TraceLogProducer traceLogProducer;

    @Override
    public void afterPropertiesSet() throws Exception {

        disruptor = new Disruptor<>(
                TraceLogEvent::new,
                RING_BUFFER_SIZE,
                DaemonThreadFactory.INSTANCE
        );

        //创建消费者组
        disruptor.handleEventsWith(traceLogHandler);
        //启动disruptor
        disruptor.start();
        this.traceLogProducer = new TraceLogProducer(disruptor.getRingBuffer());
        logger.info("disruptor start");
    }

    public TraceLogProducer getTraceLogProducer() {
        return traceLogProducer;
    }
}
