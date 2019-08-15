package com.lgy.demo.pattern;

public enum OrderFlagEnum {

    ORDER_NEW(1, "新增"),
    ORDER_AUDIT(4, "已审核"),
    ORDER_DISTRIBUTION(9, "已配货"),
    ORDER_SEND(11, "已下发"),
    ORDER_SENDOUT(15, "已发货"),
    ORDER_CANCEL(15, "已发货");

    int key;
    String value;

    OrderFlagEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
