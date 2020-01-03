package com.lgy.demo.disruptor.tracelog;

import com.alibaba.fastjson.JSON;
import com.lgy.common.disruptor.AbstractHandler;
import org.springframework.stereotype.Service;

/**
 * @Description 日志消费者
 * @Author LGy
 * @Date 2020/1/3 17:03
 **/
@Service
public class TraceLogHandler extends AbstractHandler<TraceLogEvent> {

    @Override
    public void onEvent(TraceLogEvent event) {
        logger.info("traceLog开始消费 :" + JSON.toJSONString(event));
    }
}
