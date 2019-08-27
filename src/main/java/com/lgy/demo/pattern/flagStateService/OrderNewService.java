package com.lgy.demo.pattern.flagStateService;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.enums.OrderFlagEnum;
import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 步骤① 新增状态可以 审核、取消动作
 */
public class OrderNewService extends AbstractOrderFlag {

    @Autowired
    IOrderService orderService;

    OrderEvent orderEvent;

    public OrderNewService(OrderEvent orderEvent) {
        this.orderEvent = orderEvent;
    }

    @Override
    public Message auditOrder(OrderBean order) {
        logger.info("开始审核订单[{}]", order.getBiid());
        order.setWhco("ABC仓库");
        order.setFlag(OrderFlagEnum.ORDER_AUDIT.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("审核订单[{}]成功", order.getBiid());
            return new Message("审核订单成功", true);
        }
        logger.info("审核订单[{}]失败", order.getBiid());
        return new Message("审核订单失败", false);
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("新增状态开始取消订单[{}]", order.getBiid());
        order.setRema("新增状态取消订单");
        order.setFlag(OrderFlagEnum.ORDER_CANCEL.getKey());
        order.setUpco("SYSTEM");
        order.setUpna("SYSTEM");
        order.setUpdt(System.currentTimeMillis());
        Integer i = orderService.updateColumnsOnlyHaveValues(order);
        if (i > 0) {
            logger.info("新增状态取消订单[{}]成功", order.getBiid());
            return new Message("新增状态取消订单成功", true);
        }
        logger.info("新增状态取消订单[{}]失败", order.getBiid());
        return new Message("新增状态取消订单失败", false);
    }

}
