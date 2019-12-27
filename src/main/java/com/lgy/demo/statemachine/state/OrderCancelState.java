package com.lgy.demo.statemachine.state;

import com.lgy.demo.statemachine.OrderContext;

/**
 * 订单取消状态
 */
public class OrderCancelState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCancelState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
