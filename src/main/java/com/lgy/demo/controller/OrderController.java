package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.service.IDemoService;
import com.lgy.demo.service.IOrderService;
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

@Controller
@RequestMapping("/order")
@Api("订单")
public class OrderController extends AbstractController<OrderBean, IOrderService> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IOrderService orderService;




}
