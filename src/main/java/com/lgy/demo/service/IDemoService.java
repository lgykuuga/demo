package com.lgy.demo.service;

import com.lgy.demo.bean.DemoBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDemoService {

    int insertDemo(DemoBean demoBean);

    int deleteDemo(int id);

    int updateDemo(DemoBean demoBean);

    DemoBean queryDemoById(int id);

    List<DemoBean> queryAll();

    int setRedis(String key, String value);

    String getRedis(String key);

    void rabbitMQListener(DemoBean demoBean);
}
