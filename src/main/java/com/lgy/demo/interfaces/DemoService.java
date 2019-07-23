package com.lgy.demo.interfaces;

import com.lgy.demo.bean.DemoBean;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemoService {

    int insertDemo(DemoBean demoBean);

    int deleteDemo(int id);

    int updateDemo(DemoBean demoBean);

    DemoBean queryDemoById(int id);

    List<DemoBean> queryAll();

    int setRedis(String key, String value);

    String getRedis(String key);
}
