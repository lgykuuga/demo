package com.lgy.common.service.impl;


import com.lgy.common.dao.AbstractDao;
import com.lgy.common.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础服务封装.
 * TODO Import,Export,getUser,分页
 * @param <T>
 */
public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AbstractDao<T> abstractDao;

    public AbstractServiceImpl() {
    }

    @Override
    public Integer save(T t) {
         return abstractDao.save(t);
    }

    @Override
    public Integer save(Collection<T> beans) {
        return abstractDao.save(beans);
    }

    @Override
    public Integer delete(Long id) {
        return abstractDao.delete(id);
    }

    @Override
    public Integer delete(T t) {
        try {
            return abstractDao.delete(t);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer delete(Collection<T> beans) {
        try {
            return abstractDao.delete(beans);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer deleteByIds(String ids) {
        return abstractDao.deleteByIds(ids);
    }

    @Override
    public Integer deleteByIds(Collection<Long> ids) {
        return abstractDao.deleteByIds(ids);
    }

    @Override
    public Integer deleteAll() {
        try {
            return abstractDao.deleteAll();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer updateColumnsAll(T t) {
        return abstractDao.updateColumnsAll(t);
    }

    @Override
    public Integer updateColumnsOnlyHaveValues(T t) {
        return abstractDao.updateColumnsOnlyHaveValues(t);
    }

    @Override
    public T findOneById(Long id) {
        return abstractDao.findOneById(id);
    }

    @Override
    public List<T> findAll() {
        return abstractDao.findAll();
    }

    @Override
    public T findOne(String column, String value) {
        return abstractDao.findOne(column, value);
    }

    /**
     * 根据条件查询
     */
    @Override
    public List<T> findAllByMap(Map<String, Object> map) {
        return abstractDao.findAllByMap(map);
    }

    /**
     * 根据单号修改
     * @param t
     * @return
     */
    @Override
    public Integer updateByBiid(T t) {
        try {
            return abstractDao.updateByBiid(t);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
