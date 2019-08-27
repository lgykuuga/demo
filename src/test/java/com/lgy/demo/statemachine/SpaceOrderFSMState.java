package com.lgy.demo.statemachine;

public enum SpaceOrderFSMState {
    NOPAY_NOORDER(1020, "待支付待下单"),
    NOPAY_ORDERFAILED(1023, "待支付下单失败"),
    NOPAY_NOCONFIRM(1010, "待支付待确认");

    Integer key;
    String value;

    SpaceOrderFSMState(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}