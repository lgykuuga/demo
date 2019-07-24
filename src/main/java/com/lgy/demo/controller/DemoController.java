package com.lgy.demo.controller;


import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
@Api("Demo Controller模块")
public class DemoController {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IDemoService demoService;

    @ApiOperation(value = "say hello", httpMethod = "POST", notes = "返回一个hello World")
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        logger.info("接收say hello");
        return "hello world!";
    }

    @RequestMapping(value = "/insert", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int insertDemo(DemoBean demoBean) {
        logger.info("insertDemo：[{}]", demoBean.toString());
        return demoService.insertDemo(demoBean);
    }

    @RequestMapping(value = "/delete", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int deleteDemo(int id) {
        logger.info("deleteDemo：[{}]", id);
        return demoService.deleteDemo(id);
    }

    @RequestMapping(value = "/update", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int updateDemo(DemoBean demoBean) {
        logger.info("updateDemo：[{}]", demoBean.toString());
        return demoService.updateDemo(demoBean);
    }

    @RequestMapping(value = "/queryDemoById", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public DemoBean queryDemoById(int id) {
        logger.info("queryDemoById：[{}]", id);
        return demoService.queryDemoById(id);
    }

    @RequestMapping(value = "/queryAll", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<DemoBean> queryAllDemo() {
        logger.info("queryAllDemo()");
        return demoService.queryAll();
    }

    @RequestMapping(value = "/setRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int setRedis(String key, String value) {
        logger.info("setRedis()：[{}],[{}]", key, value);
        return demoService.setRedis(key, value);
    }

    @RequestMapping(value = "/getRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String getRedis(String key) {
        logger.info("getRedis()：[{}]", key);
        return demoService.getRedis(key);
    }

    @RequestMapping(value = "/handAmqpAdminProcuder", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String handAmqpAdminConsumer(String gco) {
        logger.info("handAmqpAdminConsumer()：[{}]", gco);
        if (StringUtils.isEmpty(gco)) {
            return "gco不能为空";
        }
        demoService.handAmqpAdminProcuder(gco);
        logger.info("handAmqpAdminConsumer return：写入成功");
        return "写入成功";
    }


}
