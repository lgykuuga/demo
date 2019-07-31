package com.lgy.demo.elasticsearch;

import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.repository.DemoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcTest {

    @Autowired
    DemoRepository demoRepository;

    public EcTest() {
        System.setProperty("es.set.netty.runtime.available.processors","false");
    }

    @Test
    public void save() {
        DemoBean demoBean = new DemoBean();
        demoBean.setGco("aaa");
        demoBean.setGna("ccc");
        demoBean.setCrco("save");
        demoBean.setCrdt(System.currentTimeMillis());
        DemoBean demo = demoRepository.save(demoBean);
        System.out.println(demo.toString());
    }

    @Test
    public void index() {
        DemoBean demoBean = new DemoBean();
        demoBean.setGco("aaa");
        demoBean.setGna("bbb");
        demoBean.setCrco("index");
        demoBean.setCrdt(System.currentTimeMillis());
        DemoBean demo = demoRepository.index(demoBean);
        System.out.println(demo.toString());
    }

    @Test
    public void findAll() {
        Iterable<DemoBean> demoAll = demoRepository.findAll();
        demoAll.forEach(demo -> {
            System.out.println(demo.toString());
        });
    }


}
