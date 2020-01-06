package com.lgy.common.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lgy.common.dao.AbstractDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    private Class<T> t;

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public Integer save(T t) {
        //TODO 需要记录创建人、创建时间和数据权限.
        return baseMapper.insert(t);
    }

    @Override
    public Integer save(Collection<T> beans) {
        int count = 0;
        for (T t: beans) {
            int i = save(t);
            count += i;
        }
        return count;
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
    public Integer delete(T t) throws NoSuchFieldException {
        Class<?> aClass = t.getClass();
        Field id = aClass.getField("id");
        return baseMapper.deleteById(id.toString());
    }

    @Override
    public Integer delete(Collection<T> beans) throws NoSuchFieldException {
        int count = 0;
        for (T t: beans) {
            count += delete(t);
        }
        return count;
    }

    @Override
    public Integer deleteAll() throws NoSuchFieldException {
        return delete(findAll());
    }

    @Override
    public Integer updateColumnsAll(T t) {
        return baseMapper.updateById(t);
    }

    @Override
    public Integer updateByBiid(T t) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<>();
        String biid = t.getClass().getMethod("getBiid").invoke(t).toString();
        updateWrapper.eq("biid", biid);
        return baseMapper.update(t, updateWrapper);
    }

    /**
     * 根据ID修改不为空的值
     */
    @Override
    public Integer updateColumnsOnlyHaveValues(T t) {
        return baseMapper.updateById(t);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public T findOneById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public T findOne(String column, String value) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("column", value);
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 根据条件查询
     * @param map 传入查询参数值
     * @return 返回对象List
     */
    @Override
    public List<T> findAllByMap(Map<String, Object> map) {
        return baseMapper.selectByMap(map);
    }

}
