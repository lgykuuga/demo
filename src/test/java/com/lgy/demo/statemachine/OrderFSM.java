package com.lgy.demo.statemachine;

public class OrderFSM {
    //待支付待下单状态
    private SpaceOrderFSMState fsmSpaceState = SpaceOrderFSMState.NOPAY_NOORDER;

    private OrderFSMContextData contextData;

    public static OrderFSM init(OrderFSMContextData contextData) {
        return new OrderFSM(contextData);
    }

    public OrderFSM(OrderFSMContextData contextData) {
        this.contextData = contextData;
    }

    public OrderFSM fire(FSMEvent event) throws Exception {
        OrderFSM fsm = null;

        switch (event) {
            case ORDER_CREATE:
                fsm = orderCreate(contextData);
                break;
            default:
                throw new Exception("订单FSM不支持的事件类型");
        }
        return fsm;
    }

    public SpaceOrderFSMState getFsmSpaceState() {
        return fsmSpaceState;
    }

    public enum FSMEvent {

        ORDER_CREATE, //订单创建
        BUSINOTIFY_ORDERFAILED,//业务结果通知，下单失败
    }
    //以订单创建为例
    private OrderFSM orderCreate(OrderFSMContextData contextData) throws Exception {
        if (fsmSpaceState != SpaceOrderFSMState.NOPAY_NOORDER) {
            throw new Exception("FSM:当前状态不允许 ORDER_CREATE 事件");
        }
        //分销
        if (contextData.isDistribute()) {
            if (contextData.isPayed()) {
                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOORDER : SpaceOrderFSMState.NOPAY_ORDERFAILED;
            } else {
                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
            }
        } else {
            //非分销
            this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
        }
        return this;
    }
}
