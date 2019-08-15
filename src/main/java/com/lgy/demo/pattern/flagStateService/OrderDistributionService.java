package com.lgy.demo.pattern.flagStateService;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   步骤③ 配货状态可以 下发、取消动作
 * */
public class OrderDistributionService extends AbstractOrderFlag {

    @Autowired
    IOrderService orderService;

    OrderEvent orderEvent;

    public OrderDistributionService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }

    @Override
    public Message sendOrder(OrderBean order) {
        logger.info("开始下发订单[{}]", order.getBiid());
        order.setFlag(OrderFlagEnum.ORDER_SEND.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("下发订单[{}]成功", order.getBiid());
            return new Message("下发订单成功", true);
        }
        logger.info("下发订单[{}]失败", order.getBiid());
        return new Message("下发订单失败", false);
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("配货状态开始取消订单[{}]", order.getBiid());
        order.setRema("配货状态取消订单");
        order.setFlag(OrderFlagEnum.ORDER_CANCEL.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("配货状态取消订单[{}]成功", order.getBiid());
            return new Message("配货状态取消订单成功", true);
        }
        logger.info("配货状态取消订单[{}]失败", order.getBiid());
        return new Message("配货状态取消订单失败", false);
    }
}
