package com.lgy.demo.controller;


import com.alibaba.fastjson.JSON;
import com.lgy.demo.bean.TraceLogBean;
import com.lgy.demo.disruptor.tracelog.TraceLogApi;
import com.lgy.demo.service.ITraceLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/trace")
@Api("traceLog Controller模块")
public class TraceLogController {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TraceLogApi traceLogApi;

    @Autowired
    ITraceLogService traceLogService;

    @ApiOperation(value = "新增订单轨迹信息", httpMethod = "POST", notes = "生产一个TraceLog")
    @RequestMapping("/addTraceLog")
    @ResponseBody
    public String addTraceLog(TraceLogBean traceLog) {
        logger.info("接收:[{}]", JSON.toJSONString(traceLog));
        return traceLogApi.addTraceLogAction(traceLog);
    }

    @ApiOperation(value = "查询订单轨迹信息", httpMethod = "POST", notes = "查询")
    @RequestMapping("/get")
    @ResponseBody
    public List<TraceLogBean> get(String orderId) {
        logger.info("查询订单轨迹信息:[{}]", orderId);
        return traceLogService.getByOrderId(orderId);
    }

}
