
package com.lgy.common.util;

/**
 * 统一返回结果 Message.
 */
public class Message {

    /** 消息. */
    private String msg;
    /** 消息状态. */
    private boolean status;
    /** 消息实体对象 */
    private Object object;

    /**
     * 带参构造器.
     * @param msg 通知消息.
     * @param status 消息状态.
     */
    public Message(String msg, boolean status) {
        this.msg = msg;
        this.status = status;
    }

    /**
     * 带参构造器.
     * @param msg 通知消息.
     * @param status 消息状态.
     * @param o 返回对象
     */
    public Message(String msg, boolean status, Object o) {
        this.msg = msg;
        this.status = status;
        this.object = o;
    }
    
    /** 默认构造器. */
    public Message() {
        this.status = false;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
    
    
}