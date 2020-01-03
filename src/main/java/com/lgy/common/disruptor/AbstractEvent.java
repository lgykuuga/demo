package com.lgy.common.disruptor;

import java.io.Serializable;

public abstract class AbstractEvent<T> implements Serializable, Cloneable {

    /**
     * 序列化的时候的版本号码
     */
    private static final long serialVersionUID = 1L;


}
