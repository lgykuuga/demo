package com.lgy.common.disruptor;

import java.io.Serializable;

/**
 * @Description 事件消息
 * @Author LGy
 * @Date 2020/1/7
 */
public abstract class AbstractEvent<T> implements Serializable, Cloneable {

    /**
     * 序列化的时候的版本号码
     */
    private static final long serialVersionUID = 1L;


}
