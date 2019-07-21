package com.lgy.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {

    }


    @Test
    public void testMySQL() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t");
        System.out.println("size:" + maps.size());
    }

    @Test
    public void testMySQLforUpdate() {
        int i = jdbcTemplate.update("update t set a = ? where b = ?", new Object[]{1, 2});
        System.out.println("成功update:" + i);
    }

}
