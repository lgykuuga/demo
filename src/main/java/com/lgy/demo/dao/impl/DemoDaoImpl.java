package com.lgy.demo.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lgy.common.dao.impl.AbstractDaoImpl;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.dao.IDemoDao;
import com.lgy.demo.mapper.DemoMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class DemoDaoImpl extends AbstractDaoImpl<DemoBean> implements IDemoDao, DemoMapper {


    @Override
    public int insert(DemoBean entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<DemoBean> wrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(DemoBean entity) {
        return 0;
    }

    @Override
    public int update(DemoBean entity, Wrapper<DemoBean> updateWrapper) {
        return 0;
    }

    @Override
    public DemoBean selectById(Serializable id) {
        return null;
    }

    @Override
    public List<DemoBean> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<DemoBean> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public DemoBean selectOne(Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public Integer selectCount(Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public List<DemoBean> selectList(Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public IPage<DemoBean> selectPage(IPage<DemoBean> page, Wrapper<DemoBean> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<DemoBean> page, Wrapper<DemoBean> queryWrapper) {
        return null;
    }
}
