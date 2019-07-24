package com.lgy.demo.mybatis_plus;

import com.lgy.demo.bean.StudBean;
import com.lgy.demo.mapper.StudMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlus {


    @Resource
    private StudMapper studMapper;


    @Test
    public void testSelect2() {
        List<StudBean> studList = studMapper.selectList(null);
        studList.forEach(stud -> {
            System.out.println(stud.getCrco());
            System.out.println(stud);
        });
    }


}
