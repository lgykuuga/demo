package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;

/**
 * 订单审核状态
 */
public class OrderAuditState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderAuditState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    @Override
    public Message distributionOrder(OrderBean order) {
        logger.info("审核状态订单配货[{}]", order.getBiid());
        Message message = new Message();
        boolean flag = false;
        StringBuffer msg = new StringBuffer();
        //随机返回成功or失败
        if (getRandomBoolean()) {

            order.setFlag(OrderStateEnum.ORDER_DISTRIBUTION.key);
            orderContext.setState(orderContext.getOrderDistributionState());
            msg.append("配货成功");
            flag = true;
        } else {
            msg.append("配货失败");
        }
        message.setStatus(flag);
        message.setObject(order);
        message.setMsg(msg.toString());
        logger.info(msg.toString());
        return message;
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("审核状态取消订单[{}]", order.getBiid());
        Message message = new Message();
        String rema = "取消原因:审核状态手动取消";
        order.setRema(rema);
        message.setStatus(true);
        message.setMsg(rema);
        message.setObject(order);
        orderContext.setState(orderContext.getOrderCancelState());
        return message;
    }
}
