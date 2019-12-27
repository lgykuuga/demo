package com.lgy.demo.statemachine.state;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.statemachine.OrderContext;

/**
 * 订单配货状态
 */
public class OrderDistributionState extends AbstractOrderState{

    OrderContext orderContext;

    public OrderDistributionState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    @Override
    public Message pushOrder(OrderBean order) {
        logger.info("配货状态订单下发[{}]", order.getBiid());
        Message message = new Message();
        boolean flag = false;
        StringBuffer msg = new StringBuffer();
        //随机返回成功or失败
        if (getRandomBoolean()) {
            orderContext.setState(orderContext.getOrderPushState());
            msg.append("下发成功");
            flag = true;
        } else {
            msg.append("下发失败");
        }
        message.setStatus(flag);
        message.setObject(order);
        message.setMsg(msg.toString());
        logger.info(msg.toString());
        return message;
    }

    @Override
    public Message cancelOrder(OrderBean order) {
        logger.info("配货状态取消订单[{}]", order.getBiid());

        Message message = new Message();
        String rema = "取消原因:配货状态手动取消";
        order.setRema(rema);
        message.setStatus(true);
        message.setMsg(rema);
        message.setObject(order);
        orderContext.setState(orderContext.getOrderCancelState());
        return message;
    }
}
