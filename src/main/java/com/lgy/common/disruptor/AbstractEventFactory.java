package com.lgy.common.disruptor;

import com.lmax.disruptor.EventFactory;

import java.lang.reflect.ParameterizedType;

/**
 * @Description AbstractEventFactory
 * @Author LGy
 * @Date 2020/1/3 16:45
 **/
public abstract class AbstractEventFactory<T> implements EventFactory {

    ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
    Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
    T o;

    {
        try {
            o = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object newInstance() {
        return o;
    }
}
