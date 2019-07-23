package com.lgy.demo.controller;


import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/demo")
@Api("Demo Controller模块")
public class DemoController {

    @Resource
    IDemoService demoService;

    @ApiOperation(value = "say hello", httpMethod = "POST", notes = "返回一个hello World")
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        System.out.println("接收say hello");
        return "hello world!";
    }

    @RequestMapping(value = "/insert", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int insertDemo(DemoBean demoBean) {
        return demoService.insertDemo(demoBean);
    }

    @RequestMapping(value = "/delete", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int deleteDemo(int id) {
        return demoService.deleteDemo(id);
    }

    @RequestMapping(value = "/update", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int updateDemo(DemoBean demoBean) {
        return demoService.updateDemo(demoBean);
    }

    @RequestMapping(value = "/queryDemoById", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public DemoBean queryDemoById(int id) {
        return demoService.queryDemoById(id);
    }

    @RequestMapping(value = "/queryAll", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<DemoBean> queryAll() {
        return demoService.queryAll();
    }

    @RequestMapping(value = "/setRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int setRedis(String key, String value) {
        return demoService.setRedis(key, value);
    }

    @RequestMapping(value = "/getRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String getRedis(String key) {
        return demoService.getRedis(key);
    }


}
