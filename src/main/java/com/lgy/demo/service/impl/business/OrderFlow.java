package com.lgy.demo.service.impl.business;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.enums.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import com.lgy.demo.statemachine.OrderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  订单流程
 */
@Service
public class OrderFlow {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IOrderService orderService;

    public Message orderFlow(OrderBean order) {

        order = orderService.factory(order);

        OrderContext orderContext = new OrderContext();

        //审核
        Message auditMessage = orderContext.auditOrder(order);
        if (auditMessage.isStatus()) {
            orderService.updateOrderFlag(order, OrderFlagEnum.ORDER_AUDIT);
        } else {
            order.setRema(auditMessage.getMsg());
            orderService.updateByBiid(order);
            return null;
        }
        //配货
        Message distributionMessage = orderContext.distributionOrder(order);
        if (distributionMessage.isStatus()) {
            orderService.updateOrderFlag(order, OrderFlagEnum.ORDER_DISTRIBUTION);
        } else {
            order.setRema(distributionMessage.getMsg());
            orderService.updateByBiid(order);
            return null;
        }
        //推送
        Message pushMessage = orderContext.pushOrder(order);
        if (pushMessage.isStatus()) {
            orderService.updateOrderFlag(order, OrderFlagEnum.ORDER_SEND);
        } else {
            order.setRema(pushMessage.getMsg());
            orderService.updateByBiid(order);
            return null;
        }
        //发货完成
        Message sendoutMessage = orderContext.sendoutOrder(order);
        if (sendoutMessage.isStatus()) {
            orderService.updateOrderFlag(order, OrderFlagEnum.ORDER_SENDOUT);
        } else {
            order.setRema(sendoutMessage.getMsg());
            orderService.updateByBiid(order);
            return null;
        }
        //完结订单
        Message completeMessage = orderContext.completeOrder(order);
        if (completeMessage.isStatus()) {
            orderService.updateOrderFlag(order, OrderFlagEnum.ORDER_COMPLETE);
        } else {
            order.setRema(completeMessage.getMsg());
            orderService.updateByBiid(order);
            return null;
        }

        //随机取消订单
        if (getRandomBoolean()) {
            OrderBean finalOrder = order;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    logger.info("随机取消订单:[{}]", finalOrder.getBiid());
                    Message cancelMessage = orderContext.cancelOrder(finalOrder);
                    if (cancelMessage.isStatus()) {
                        orderService.updateOrderFlag(finalOrder, OrderFlagEnum.ORDER_CANCEL);
                    }
                }
            }).start();
        }
        return new Message("", true);
    }

    public boolean getRandomBoolean() {
//          Random random = new Random();
//        return random.nextBoolean();
        //80%成功
        if ((Math.random()*100) > 80) {
            return true;
        }
        return false;
    }


}
