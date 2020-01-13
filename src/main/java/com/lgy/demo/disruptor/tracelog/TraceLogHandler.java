package com.lgy.demo.disruptor.tracelog;

import com.alibaba.fastjson.JSON;
import com.lgy.common.disruptor.AbstractHandler;
import com.lgy.demo.bean.TraceLogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description 日志消费者
 * @Author LGy
 * @Date 2020/1/3 17:03
 **/
@Service
public class TraceLogHandler extends AbstractHandler<TraceLogEvent> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onEvent(TraceLogEvent event) {
        TraceLogBean traceLog = event.getTraceLog();
        traceLog.setCreateTime(new Date().toString());
        logger.info("traceLog开始消费 :" + JSON.toJSONString(event));
        mongoTemplate.save(event.getTraceLog());
    }
}
