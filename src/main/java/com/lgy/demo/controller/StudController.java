package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.service.IStudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/stud")
@Api("stud Controller模块")
public class StudController extends AbstractController<StudBean, IStudService> {

    @Resource
    IStudService studService;

    @ApiOperation(value = "say hello", httpMethod = "POST", notes = "返回一个hello World")
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String name) {
        logger.info("接收say hello " + name);
        return name + " hello world!";
    }

}
