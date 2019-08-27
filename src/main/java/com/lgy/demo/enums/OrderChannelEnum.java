package com.lgy.demo.enums;

/**
 * 订单渠道
 */
public enum OrderChannelEnum {

    SELF(1, "自营"),
    THIRD_PARTY(2, "第三方"),
    OPEN_PLATFORM(3, "开放平台"),
    EXTERNAL(4, "外部"),
    OTHER(5, "其它");

    Integer key;
    String value;

    OrderChannelEnum(Integer key, String value) {
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
