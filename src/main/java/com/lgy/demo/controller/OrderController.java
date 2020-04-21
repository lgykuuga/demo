package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.service.IOrderService;
import com.lgy.demo.service.impl.business.OrderFlow;
import com.lgy.demo.statemachine.OrderEventEnum;
import com.lgy.demo.statemachine.OrderStateEnum;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
@Api("订单")
public class OrderController extends AbstractController<OrderBean, IOrderService> {

    @Autowired
    IOrderService orderService;

    @Autowired
    OrderFlow orderFlow;

    @Resource
    private StateMachine<OrderStateEnum, OrderEventEnum> stateMachine;


    @RequestMapping(value = "/stateMachineStart", method= {RequestMethod.POST})
    @ResponseBody
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>(1);
        map.put("flag", 1);
        List<OrderBean> orders = orderService.findAllByMap(map);
        for (OrderBean order : orders) {
            logger.info("stateMachineStart:Biid[{}]", order.getBiid());
            orderFlow.orderFlow(order);
        }
    }

}
