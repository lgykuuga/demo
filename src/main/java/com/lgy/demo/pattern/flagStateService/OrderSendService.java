package com.lgy.demo.pattern.flagStateService;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   步骤④ 订单下发状态可以 接受发货完成、取消动作
 * */
public class OrderSendService extends AbstractOrderFlag {

    @Autowired
    IOrderService orderService;

    OrderEvent orderEvent;

    public OrderSendService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }

    @Override
    public Message sendOutOrder(OrderBean order) {
        logger.info("订单[{}]发货完成", order.getBiid());
        order.setFlag(OrderFlagEnum.ORDER_SENDOUT.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("订单[{}]发货完成", order.getBiid());
            return new Message("订单发货完成", true);
        }
        logger.info("订单[{}]发货完成更新失败", order.getBiid());
        return new Message("发货完成更新失败", false);
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("下发状态开始取消订单[{}]", order.getBiid());
        order.setRema("下发状态取消订单");
        order.setFlag(OrderFlagEnum.ORDER_CANCEL.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("下发状态取消订单[{}]成功", order.getBiid());
            return new Message("下发状态取消订单成功", true);
        }
        logger.info("下发状态取消订单[{}]失败", order.getBiid());
        return new Message("下发状态取消订单失败", false);
    }
}
