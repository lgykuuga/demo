package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.service.IStudBeanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/stud")
@Api("stud Controller模块")
public class StudController extends AbstractController<StudBean, IStudBeanService> {

    @Resource
    IStudBeanService studService;

    @ApiOperation(value = "say hello", httpMethod = "POST", notes = "返回一个hello World")
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        logger.info("接收say hello");
        return "hello world!";
    }

}
