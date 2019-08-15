package com.lgy.demo.pattern;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;

public interface OrderFlag {

    /**
     * 交易状态。可选值: *
     * TRADE_NO_CREATE_PAY(没有创建支付宝交易)
     * * WAIT_BUYER_PAY(等待买家付款)
     * * SELLER_CONSIGNED_PART(卖家部分发货)
     * * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)
     * * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)
     * * TRADE_FINISHED(交易成功)
     * * TRADE_CLOSED(付款以后用户退款成功，交易自动关闭)
     * * TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易)
     */

    /**
     * 保存订单
     * @param order 订单对象
     * @return 返回消息对象
     */
    Message saveOrder(OrderBean order);

    /**
     * 订单审核
     * @param order 订单对象
     * @return  返回消息对象
     */
    Message auditOrder(OrderBean order);

    /**
     * 订单配货
     * @param order 订单对象
     * @return 返回消息对象
     */
    Message distributionOrder(OrderBean order);

    /**
     * 推送订单
     * @param order 订单对象
     * @return 返回消息对象
     */
    Message sendOrder(OrderBean order);

    /**
     * 订单发货完成
     * @param order 订单对象
     * @return 返回消息对象
     */
    Message sendOutOrder(OrderBean order);

    /**
     * 取消订单
     * @param order 订单对象
     * @return  返回消息对象
     */
    Message cancelOrder(OrderBean order);

}
