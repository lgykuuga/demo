package com.lgy.demo.interfaces;

import com.lgy.demo.bean.DemoBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemoService {

    int insertDemo(DemoBean demoBean);

    int deleteDemo(int id);

    int updateDemo(DemoBean demoBean);

    DemoBean queryDemoById(int id);

    List<DemoBean> queryAll();

}
