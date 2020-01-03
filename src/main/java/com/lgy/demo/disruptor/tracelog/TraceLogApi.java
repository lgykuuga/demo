package com.lgy.demo.disruptor.tracelog;

import com.alibaba.fastjson.JSON;
import com.lgy.demo.bean.TraceLogBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 调用轨迹日志Disruptor
 * @Author LGy
 * @Date 2019/12/30
 */
@Service
public class TraceLogApi {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TraceLogDisruptorUtil disruptorTraceLogUtil;

    public String addTraceLogAction(TraceLogBean traceLog) {

        TraceLogEvent event = new TraceLogEvent();
        event.setTraceLog(traceLog);

        disruptorTraceLogUtil.getTraceLogProducer().onData(event);
        logger.info("生产traceLog:" + JSON.toJSONString(traceLog));
        return "success";
    }
}
