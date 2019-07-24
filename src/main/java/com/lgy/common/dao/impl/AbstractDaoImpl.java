package com.lgy.common.dao.impl;

import com.lgy.common.dao.AbstractDao;
import com.lgy.common.mapper.AbstractMapper;
import com.lgy.demo.mapper.DemoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 *  TODO 实现CRUD封装,用jdbc or Mybatis
 *   所有基于业务处理的数据访问均集成于该类，这样无论底层如何变化，对上面访问者而言，均是透明;
 *   同时对于底层的改动，无需担忧访问者的代码升级.
 */
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AbstractMapper<T> abstractMapper;

    @Override
    public Integer save(T t) {
        return abstractMapper.save(t);
    }

    @Override
    public Integer save(Collection<T> beans) {
        return abstractMapper.save(beans);
    }

    @Override
    public Integer delete(Long id) {
        return abstractMapper.delete(id);
    }

    @Override
    public Integer delete(T t) {
        return abstractMapper.delete(t);
    }

    @Override
    public Integer delete(Collection<T> beans) {
        return abstractMapper.delete(beans);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return abstractMapper.deleteByIds(ids);
    }

    @Override
    public Integer deleteByIds(Collection<Long> ids) {
        return abstractMapper.deleteByIds(ids);
    }

    @Override
    public Integer deleteAll() {
        return abstractMapper.deleteAll();
    }

    @Override
    public Integer updateColumnsAll(T t) {
        return abstractMapper.updateColumnsAll(t);
    }

    @Override
    public Integer updateColumnsOnlyHaveValues(T t) {
        return abstractMapper.updateColumnsOnlyHaveValues(t);
    }

    @Override
    public T findOne(Long id) {
        return abstractMapper.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return abstractMapper.findAll();
    }

}
