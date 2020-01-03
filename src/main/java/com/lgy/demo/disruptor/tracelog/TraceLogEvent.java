package com.lgy.demo.disruptor.tracelog;

import com.lgy.common.disruptor.AbstractEvent;
import com.lgy.demo.bean.TraceLogBean;

/**
 * @Description 轨迹日志Event
 * @Author LGy
 * @Date 2020/1/3 12:10
 **/
public class TraceLogEvent extends AbstractEvent<TraceLogBean> {

    /**
     * 轨迹日志
     */
    private TraceLogBean traceLog;

    public TraceLogBean getTraceLog() {
        return traceLog;
    }

    public void setTraceLog(TraceLogBean traceLog) {
        this.traceLog = traceLog;
    }
}
