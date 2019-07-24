package com.lgy.demo.mp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.mapper.StudMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTestUpdate {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private StudMapper studMapper;


    @Test
    public void update() {
        StudBean stud = new StudBean();
        stud.setAge(26);
        stud.setUpco("MyBatisPlus");
        stud.setUpna("MyBatisPlus");
        stud.setUpdt(System.currentTimeMillis());

        UpdateWrapper<StudBean> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("gco", "002");
        int i = studMapper.update(stud, updateWrapper);
        logger.info("影响行数[{}]", i);
    }


    /**
     * update age = 24 from stud where gco = "002"
     */
    @Test
    public void updateBySet() {
        StudBean stud = new StudBean();
        stud.setGco("002");
        UpdateWrapper<StudBean> updateWrapper = new UpdateWrapper<>(stud);
        updateWrapper.set("age", 24).set("upco", "MyBatisPlus").set("upna", "MyBatisPlus").set("updt", System.currentTimeMillis());
        int i = studMapper.update(stud, updateWrapper);
        logger.info("影响行数[{}]", i);
    }

}
