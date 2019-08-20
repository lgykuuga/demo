package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单完成状态
 */
public class OrderCompleteState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderCompleteState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }
}
