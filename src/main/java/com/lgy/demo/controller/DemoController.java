package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
@Api("Demo Controller模块")
public class DemoController extends AbstractController<DemoBean, IDemoService> {

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

    @RequestMapping(value = "/setRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int setRedis(String key, String value) {
        logger.info("setRedis()：[{}],[{}]", key, value);
        return demoService.setRedis(key, value);
    }

    @RequestMapping(value = "/getRedis", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String getRedis(@PathVariable String key) {
        logger.info("getRedis()：[{}]", key);
        return demoService.getRedis(key);
    }

    @RequestMapping(value = "/handAmqpAdminProcuder", method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String handAmqpAdminConsumer(DemoBean demo) {
        logger.info("handAmqpAdminConsumer()：[{}]", demo.toString());
        if (StringUtils.isEmpty(demo.getGco())) {
            return "gco不能为空";
        }
        demoService.handAmqpAdminProcuder(demo);
        logger.info("handAmqpAdminConsumer return：写入成功");
        return "写入成功";
    }


}
