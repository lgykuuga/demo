package com.lgy.demo.statemachine;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;

public interface OrderState {

    /**
     * 保存订单
     * @param order
     * @return
     */
    Message saveOrder(OrderBean order);

    /**
     * 审核订单
     * @param order
     * @return
     */
    Message auditOrder(OrderBean order);

    /**
     * 订单配货
     * @param order
     * @return
     */
    Message distributionOrder(OrderBean order);

    /**
     * 下发订单
     * @param order
     * @return
     */
    Message pushOrder(OrderBean order);

    /**
     * 发货完成
     * @param order
     * @return
     */
    Message sendoutOrder(OrderBean order);

    /**
     * 完结订单
     * @param order
     * @return
     */
    Message completeOrder(OrderBean order);

    /**
     * 取消订单
     * @param order
     * @return
     */
    Message cancelOrder(OrderBean order);

}
