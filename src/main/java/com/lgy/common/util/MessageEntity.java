package com.lgy.common.util;

import java.io.Serializable;

public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String channel;
    //主键
    private String key;
    //消息类型 sql同步、文件更新等
    private String type;
    //业务类型 订单同步、商品同步等(方法  增、删、改、查)
    private String method;
    //消息对像
    private String value;
    //是否成功 true成功，false失败
    private Boolean flag = true;

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
