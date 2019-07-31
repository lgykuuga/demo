package com.lgy.demo.service;

import com.lgy.common.service.AbstractService;
import com.lgy.demo.bean.DemoBean;

public interface IDemoService extends AbstractService<DemoBean> {

    int setRedis(String key, String value);

    String getRedis(String key);

    void rabbitMQListener(DemoBean demoBean);

    void handAmqpAdminProcuder(DemoBean demoBean);

    DemoBean factory(DemoBean demoBean);

}
