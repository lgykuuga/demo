package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;

/**
 * 订单已发货状态
 */
public class OrderSendOutState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderSendOutState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    @Override
    public Message completeOrder(OrderBean order) {
        logger.info("已发货状态完结订单[{}]", order.getBiid());
        Message message = new Message();
        boolean flag = false;
        StringBuffer msg = new StringBuffer();
        //随机返回成功or失败
        if (getRandomBoolean()) {
            orderContext.setState(orderContext.getOrderCompleteState());
            msg.append("完结订单成功");
            flag = true;
        } else {
            msg.append("完结订单失败");
        }
        message.setMsg(msg.toString());
        message.setStatus(flag);
        message.setObject(order);
        logger.info(msg.toString());
        return message;
    }
}
