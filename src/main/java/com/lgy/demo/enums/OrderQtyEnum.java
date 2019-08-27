package com.lgy.demo.enums;

public enum OrderQtyEnum {

    S(1, "一单一货"),
    M(2, "一单多货"),
    B(3, "大单");

    Integer key;
    String value;

    OrderQtyEnum(Integer key, String value) {
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
