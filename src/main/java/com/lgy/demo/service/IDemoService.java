package com.lgy.demo.service;

import com.lgy.demo.bean.DemoBean;

import java.util.List;

public interface IDemoService {

    int insertDemo(DemoBean demoBean);

    int deleteDemo(int id);

    int updateDemo(DemoBean demoBean);

    DemoBean queryDemoById(int id);

    List<DemoBean> queryAll();

    int setRedis(String key, String value);

    String getRedis(String key);

    void rabbitMQListener(DemoBean demoBean);

    void handAmqpAdminProcuder(String gco);

    DemoBean factory();

}
