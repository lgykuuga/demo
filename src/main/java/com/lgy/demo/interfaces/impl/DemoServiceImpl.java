package com.lgy.demo.interfaces.impl;


import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.interfaces.DemoService;
import com.lgy.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    DemoMapper demoMapper;

    @Override
    public int insertDemo(DemoBean demoBean) {
        return demoMapper.insertDemo(demoBean);
    }

    @Override
    public int deleteDemo(int id) {
        return demoMapper.deleteDemo(id);
    }

    @Override
    public int updateDemo(DemoBean demoBean) {
        return demoMapper.updateDemo(demoBean);
    }

    @Override
    public DemoBean queryDemoById(int id) {
        return demoMapper.queryDemoById(id);
    }

    @Override
    public List<DemoBean> queryAll() {
        return demoMapper.queryAll();
    }
}
