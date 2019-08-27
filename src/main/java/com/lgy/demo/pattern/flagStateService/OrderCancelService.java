package com.lgy.demo.pattern.flagStateService;

import com.lgy.demo.pattern.AbstractOrderFlag;

/**
 *   取消状态
 * */
public class OrderCancelService extends AbstractOrderFlag {

    OrderEvent orderEvent;

    public OrderCancelService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }
}
