package com.lgy.demo.enums;

public enum OrderFlagEnum {

    ORDER_NEW(1, "新增"),
    ORDER_AUDIT(4, "已审核"),
    ORDER_DISTRIBUTION(9, "已配货"),
    ORDER_SEND(11, "已下发"),
    ORDER_SENDOUT(15, "已发货"),
    ORDER_CANCEL(95, "已取消"),
    ORDER_COMPLETE(99, "已完成");

    Integer key;
    String value;

    OrderFlagEnum(Integer key, String value) {
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
