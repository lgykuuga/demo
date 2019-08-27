package com.lgy.demo.pattern.flagStateService;

import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 发货完成状态
 */
public class OrderSendOutService extends AbstractOrderFlag {

    @Autowired
    IOrderService orderService;

    OrderEvent orderEvent;

    public OrderSendOutService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }
}
