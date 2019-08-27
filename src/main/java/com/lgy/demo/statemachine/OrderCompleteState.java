package com.lgy.demo.statemachine;

/**
 * 订单完成状态
 */
public class OrderCompleteState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCompleteState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
