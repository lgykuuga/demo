package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单已下发状态
 */
public class OrderPushState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderPushState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    @Override
    public Message sendoutOrder(OrderBean order) {
        logger.info("已下发状态接收发货回传订单[{}]", order.getBiid());
        Message message = new Message();
        boolean flag = false;
        StringBuffer msg = new StringBuffer();
        //随机返回成功or失败
        if (getRandomBoolean()) {
            orderContext.setState(orderContext.getOrderSendOutState());
            msg.append("接收已发货订单成功");
            flag = true;
        } else {
            msg.append("接收已发货订单失败");
        }
        message.setStatus(flag);
        message.setObject(order);
        message.setMsg(msg.toString());
        logger.info(msg.toString());
        return message;
    }
}
