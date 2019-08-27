package com.lgy.demo.statemachine;

/**
 * 订单取消状态
 */
public class OrderCancelState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCancelState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
