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
 * @Date 2020/6/9
 **/
@Service
public class TraceLogHandlerTest extends AbstractHandler<TraceLogEvent> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onEvent(TraceLogEvent event) {
        logger.info("TraceLogHandlerTest开始消费 :" + JSON.toJSONString(event));
        throw new RuntimeException();
//        mongoTemplate.save(event.getTraceLog());
    }
}
