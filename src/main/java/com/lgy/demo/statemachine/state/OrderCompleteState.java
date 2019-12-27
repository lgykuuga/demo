package com.lgy.demo.statemachine.state;

import com.lgy.demo.statemachine.OrderContext;

/**
 * 订单完成状态
 */
public class OrderCompleteState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCompleteState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
