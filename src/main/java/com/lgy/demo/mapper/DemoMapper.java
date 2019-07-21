package com.lgy.demo.mapper;

import com.lgy.demo.bean.DemoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper {

    int insertDemo(DemoBean demoBean);

    int deleteDemo(int id);

    int updateDemo(DemoBean demoBean);

    DemoBean queryDemoById(int id);

    List<DemoBean> queryAll();


}
