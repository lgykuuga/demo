package com.lgy.common.dao.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lgy.common.dao.AbstractDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *  TODO 实现CRUD封装,用jdbc or Mybatis
 *   所有基于业务处理的数据访问均集成于该类，这样无论底层如何变化，对上面访问者而言，均是透明;
 *   同时对于底层的改动，无需担忧访问者的代码升级.
 *
 *   简单的CRUD、分页查询操作由mybatis plus完成,在各自业务模块注入对应mapper实现。
 *   导入导出、数据权限业务由自己业务封装完成
 *
 */
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public Integer save(T t) {
        //TODO 需要记录创建人、创建时间和数据权限.
        return baseMapper.insert(t);
    }

    @Override
    public Integer save(Collection<T> beans) {
        return null;
    }

    @Override
    public Integer delete(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(String ids) {
        String[] idz = ids.split(",");
        return baseMapper.deleteBatchIds(Arrays.asList(idz));
    }

    @Override
    public Integer deleteByIds(Collection<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public Integer delete(T t) {
        return null;
    }

    @Override
    public Integer delete(Collection<T> beans) {
        return null;
    }

    @Override
    public Integer deleteAll() {
        return null;
    }

    @Override
    public Integer updateColumnsAll(T t) {
        return null;
    }

    /**
     * 根据ID修改不为空的值
     */
    @Override
    public Integer updateColumnsOnlyHaveValues(T t) {
        return baseMapper.updateById(t);
    }

    @Override
    public T findOne(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.selectList(null);
    }



}
