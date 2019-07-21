package com.lgy.demo.controller;


import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.interfaces.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "hello world!";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insertDemo(DemoBean demoBean) {
        return demoService.insertDemo(demoBean);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteDemo(int id) {
        return demoService.deleteDemo(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateDemo(DemoBean demoBean) {
        return demoService.updateDemo(demoBean);
    }

    @RequestMapping("/queryDemoById")
    @ResponseBody
    public DemoBean queryDemoById(int id) {
        return demoService.queryDemoById(id);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<DemoBean> queryAll() {
        return demoService.queryAll();
    }

}
