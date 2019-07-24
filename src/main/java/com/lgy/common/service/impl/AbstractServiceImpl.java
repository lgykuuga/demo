package com.lgy.common.service.impl;


import com.lgy.common.dao.AbstractDao;
import com.lgy.common.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 基础服务封装.
 * TODO Import,Export,getUser,分页
 * @param <T>
 */
public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
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
        return abstractDao.delete(t);
    }

    @Override
    public Integer delete(Collection<T> beans) {
        return abstractDao.delete(beans);
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
        return abstractDao.deleteAll();
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
    public T findOne(Long id) {
        return abstractDao.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return abstractDao.findAll();
    }

}
