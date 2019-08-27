package com.lgy.demo.statemachine;

/**
 * 订单行为枚举类
 */
public enum OrderEventEnum {

    SAVE_ORDER("保存订单"),
    AUDIT_ORDER("审核订单"),
    DISTRIBUTION_ORDER("配货订单"),
    SEND_ORDER("下发订单"),
    SENDOUT_ORDER("出库订单"),
    CANCEL_ORDER("取消订单");

    String value;

    OrderEventEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
