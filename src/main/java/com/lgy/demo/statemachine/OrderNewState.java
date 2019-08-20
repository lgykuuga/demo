package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 订单新增状态
 */
public class OrderNewState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderNewState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    @Override
    public Message auditOrder(OrderBean order) {
        logger.info("新增状态审核订单[{}]", order.getBiid());
        Message message = new Message();
        boolean flag = false;
        StringBuffer msg = new StringBuffer();
        //随机返回成功or失败
        if (getRandomBoolean()) {
            orderContext.setState(orderContext.getOrderAuditState());
            msg.append("审核成功");
            flag = true;
        } else {
            msg.append("审核失败");
        }
        message.setStatus(flag);
        message.setMsg(msg.toString());
        message.setObject(order);
        logger.info(msg.toString());
        return message;
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("新增状态取消订单[{}]", order.getBiid());
        String rema = "取消原因:新增状态手动取消";
        Message message = new Message();
        order.setRema(rema);
        message.setStatus(true);
        message.setMsg(rema);
        message.setObject(order);
        orderContext.setState(orderContext.getOrderCancelState());
        return message;
    }

}
