package com.lgy.demo.enums;

public enum OrderStatusEnum {

    VALID(1, "有效"),
    INVALID(2, "无效"),
    SPLIT(3, "被拆分"),
    MERGED(4, "被合并");

    Integer key;
    String value;

    OrderStatusEnum(Integer key, String value) {
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
