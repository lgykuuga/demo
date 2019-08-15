package com.lgy.demo.pattern.flagStateService;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.pattern.OrderFlag;
import com.lgy.demo.pattern.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 步骤② 审核状态可以 配货、取消动作
 */
public class OrderAuditService extends AbstractOrderFlag {

    @Autowired
    IOrderService orderService;

    OrderEvent orderEvent;

    public OrderAuditService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }

    @Override
    public Message distributionOrder(OrderBean order) {
        logger.info("开始配货订单[{}]", order.getBiid());
        order.setLpco("SF");
        order.setFlag(OrderFlagEnum.ORDER_DISTRIBUTION.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("审核配货[{}]成功", order.getBiid());
            return new Message("配货订单成功", true);
        }
        logger.info("配货订单[{}]失败", order.getBiid());
        return new Message("配货订单失败", false);
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("审核状态开始取消订单[{}]", order.getBiid());
        order.setRema("审核状态取消订单");
        order.setFlag(OrderFlagEnum.ORDER_CANCEL.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("审核状态取消订单[{}]成功", order.getBiid());
            return new Message("审核状态取消订单成功", true);
        }
        logger.info("审核状态取消订单[{}]失败", order.getBiid());
        return new Message("审核状态取消订单失败", false);
    }
}
