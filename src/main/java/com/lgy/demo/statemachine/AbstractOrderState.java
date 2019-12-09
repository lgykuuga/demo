package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractOrderState implements OrderState{

    public Logger logger = LoggerFactory.getLogger(getClass());

    private final static Message MESSAGE = new Message("该状态不允许此操作", false);

    @Override
    public Message saveOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message auditOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message distributionOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message pushOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message sendoutOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message completeOrder(OrderBean order) {
        return MESSAGE;
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        return MESSAGE;
    }

    public boolean getRandomBoolean() {
//        Random random = new Random();
//        return random.nextBoolean();

        if ((Math.random()*100) < 80) {
            return true;
        }
        return false;

    }

}
