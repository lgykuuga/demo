package com.lgy.demo.statemachine;


import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

public class OrderContext {

    // 订单状态
    OrderState state = null;
    // 定义各种状态
    OrderState orderNewState = new OrderNewState(this);
    OrderState orderAuditState = new OrderAuditState(this);
    OrderState orderDistributionState  = new OrderDistributionState(this);
    OrderState orderPushState = new OrderPushState(this);
    OrderState orderSendOutState  = new OrderSendOutState(this);
    OrderState orderCompleteState  = new OrderCompleteState(this);
    OrderState orderCancelState  = new OrderCancelState(this);

    public OrderContext() {
        //初始化新增状态
        this.state = getOrderNewState();
    }

    public Message auditOrder(OrderBean order){
        return state.auditOrder(order);
    }

    public Message distributionOrder(OrderBean order){
        return state.distributionOrder(order);
    }

    public Message pushOrder(OrderBean order){
        return state.pushOrder(order);
    }

    public Message sendoutOrder(OrderBean order){
        return state.sendoutOrder(order);
    }

    public Message completeOrder(OrderBean order){
        return state.completeOrder(order);
    }

    public Message cancelOrder(OrderBean order){
        return state.cancelOrder(order);
    }


    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getOrderNewState() {
        return orderNewState;
    }

    public void setOrderNewState(OrderState orderNewState) {
        this.orderNewState = orderNewState;
    }

    public OrderState getOrderAuditState() {
        return orderAuditState;
    }

    public void setOrderAuditState(OrderState orderAuditState) {
        this.orderAuditState = orderAuditState;
    }

    public OrderState getOrderDistributionState() {
        return orderDistributionState;
    }

    public void setOrderDistributionState(OrderState orderDistributionState) {
        this.orderDistributionState = orderDistributionState;
    }

    public OrderState getOrderPushState() {
        return orderPushState;
    }

    public void setOrderPushState(OrderState orderPushState) {
        this.orderPushState = orderPushState;
    }

    public OrderState getOrderSendOutState() {
        return orderSendOutState;
    }

    public void setOrderSendOutState(OrderState orderSendOutState) {
        this.orderSendOutState = orderSendOutState;
    }

    public OrderState getOrderCompleteState() {
        return orderCompleteState;
    }

    public void setOrderCompleteState(OrderState orderCompleteState) {
        this.orderCompleteState = orderCompleteState;
    }

    public OrderState getOrderCancelState() {
        return orderCancelState;
    }

    public void setOrderCancelState(OrderState orderCancelState) {
        this.orderCancelState = orderCancelState;
    }

}
