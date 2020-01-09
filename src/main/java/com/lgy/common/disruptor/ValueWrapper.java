package com.lgy.common.disruptor;

/**
 * @Description TODO
 * @Author LGy
 * @Date 2020/1/9 14:16
 **/
public abstract class ValueWrapper<T> {

    private T value;

    public ValueWrapper() {}

    public ValueWrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}