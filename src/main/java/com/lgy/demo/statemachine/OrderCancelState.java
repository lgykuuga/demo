package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单取消状态
 */
public class OrderCancelState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCancelState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
