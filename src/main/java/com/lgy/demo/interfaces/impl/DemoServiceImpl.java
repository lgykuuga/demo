package com.lgy.demo.interfaces.impl;


import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.interfaces.DemoService;
import com.lgy.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    DemoMapper demoMapper;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

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

    @Override
    public int setRedis(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return 1;
        } catch (Exception e) {
            System.out.println("setRedis Exception:" + e);
        }
        return 0;
    }

    @Override
    public String getRedis(String key) {
        try {
            String value = (String) redisTemplate.opsForValue().get(key);
            return value;
        } catch (Exception e) {
            System.out.println("getRedis Exception:" + e);
        }
        return "";
    }
}
