package com.lgy.demo.pattern;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractOrderFlag implements OrderFlag {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Message saveOrder(OrderBean order) {
        return new Message("该状态不允许新增订单", false);
    }

    @Override
    public Message auditOrder(OrderBean order) {
        return new Message("该状态不允许审核订单", false);
    }

    @Override
    public Message distributionOrder(OrderBean order) {
        return new Message("该状态不允许配货订单", false);
    }

    @Override
    public Message sendOrder(OrderBean order) {
        return new Message("该状态不允许下发订单", false);
    }

    @Override
    public Message sendOutOrder(OrderBean order) {
        return new Message("该状态不允许订单发货", false);
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        return new Message("该状态不允许取消订单", false);
    }
}
