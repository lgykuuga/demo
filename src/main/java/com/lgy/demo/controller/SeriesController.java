package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.disruptor.series.SeriesData;
import com.lgy.demo.disruptor.series.SeriesDataEventQueueHelper;
import com.lgy.demo.service.IStudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/series")
@Api("series Controller模块")
public class SeriesController extends AbstractController<StudBean, IStudService> {

    @Autowired
    private SeriesDataEventQueueHelper seriesDataEventQueueHelper;


    @ApiOperation(value = "series disruptor", httpMethod = "POST", notes = "series disruptor test")
    @RequestMapping("/demo")
    @ResponseBody
    public void demo() {
        seriesDataEventQueueHelper.publishEvent(new SeriesData("test aaa"));
    }

}
