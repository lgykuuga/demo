package com.lgy.demo.controller;


import com.alibaba.fastjson.JSON;
import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.bean.TraceLogBean;
import com.lgy.demo.disruptor.tracelog.TraceLogApi;
import com.lgy.demo.service.IStudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trace")
@Api("traceLog Controller模块")
public class TraceLogController extends AbstractController<StudBean, IStudService> {

    @Autowired
    TraceLogApi traceLogApi;

    @ApiOperation(value = "新增订单轨迹信息", httpMethod = "POST", notes = "生产一个TraceLog")
    @RequestMapping("/addTraceLog")
    @ResponseBody
    public String addTraceLog(TraceLogBean traceLog) {
        logger.info("接收:" + JSON.toJSONString(traceLog));
        return traceLogApi.addTraceLogAction(traceLog);
    }

}
