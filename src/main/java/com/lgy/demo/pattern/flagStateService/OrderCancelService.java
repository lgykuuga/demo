package com.lgy.demo.pattern.flagStateService;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   取消状态
 * */
public class OrderCancelService extends AbstractOrderFlag {

    OrderEvent orderEvent;

    public OrderCancelService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }
}
