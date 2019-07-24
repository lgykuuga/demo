package com.lgy.demo.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgy.demo.bean.StudBean;
import com.lgy.demo.mapper.StudMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTestSelect {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private StudMapper studMapper;


    @Test
    public void insert() {
        StudBean stud = new StudBean();
        stud.setGco("002");
        stud.setGna("吴晓红");
        stud.setAge(25);
        stud.setCrco("MyBatisPlus");
        stud.setCrna("MyBatisPlus");
        stud.setCrdt(System.currentTimeMillis());
        studMapper.insert(stud);
        System.out.println(stud.getId());//insert后返回ID。棒棒的
        System.out.println(stud.toString());
    }


    @Test
    public void selectAll() {
        List<StudBean> studList = studMapper.selectList(null);
        studList.forEach(stud -> {
            System.out.println(stud.getCrco());
            System.out.println(stud);
        });
    }

    /**
     * where gna = "王小明" and age = 30
     */
    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("gna", "王小明");
        map.put("age", 25);
        List<StudBean> studBeanList = studMapper.selectByMap(map);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }



    /**
     * 名字包含明且年龄小于30
     * where gna like '%明%' and age < 30
     */
    @Test
    public void selectByWapper() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gna", "明");
        queryWrapper.le("age", 30);
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 查出编码,名字包含明且年龄小于30
     * select gco from stud
     * where gna like '%明%' and age < 30
     */
    @Test
    public void selectByWapperSupper() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("gco");
        queryWrapper.like("gna", "明");
        queryWrapper.le("age", 30);
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     *  用实体当作where条件查询
     */
    @Test
    public void selectByWapperEntity() {
        StudBean whereStud = new StudBean();
        whereStud.setGco("002");
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>(whereStud);
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    @Test
    public void testCondiction() {
        String gco = "001";
        String gna = "";
        selectByWapperCondiction(gco, gna);
    }

    /**
     *  Condiction等价于判断条件
     */
    public void selectByWapperCondiction(String code, String name) {

        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty("gco"), "gco", code);
        queryWrapper.like(!StringUtils.isEmpty("gna"), "gna", name);
        //等价于下面的判断条件
//        if (!StringUtils.isEmpty("gco")) {
//            queryWrapper.eq("gco", code);
//        }
//        if (!StringUtils.isEmpty("gco")) {
//            queryWrapper.like("gna", name);
//        }

        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }


    /**
     * 名字姓王且年龄范围在20~30中且邮件不为空
     * where gna like '%明%' and age between (20, 30) and mail is not null
     */
    @Test
    public void selectByWapper2() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gna", "明");
        queryWrapper.between("age", 20, 30);
        queryWrapper.isNotNull("mail");
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 名字姓王且年龄大于等于25,按照年龄降序,再根据ID升序
     */
    @Test
    public void selectByWapper3() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("gna", "王");
        queryWrapper.ge("age", 25);
        queryWrapper.orderByDesc("age");
        queryWrapper.orderByAsc("id");
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 创建日期为2019年7月25日且上级年龄是25岁以上
     * FROM_UNIXTIME(crdt/1000, '%Y-%m-%d') = '2019-07-25' and pgco in (select gco from stud where age >= 25)
     */
    @Test
    public void selectByWapper4() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("FROM_UNIXTIME(crdt/1000, '%Y-%m-%d') = {0}", "2019-07-25");
        queryWrapper.inSql("pgco", "select gco from stud where age >= 25");
        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 姓王而且(年龄小于40或者邮箱不为空)
     * gna like '王%' and (age < 40 or mail is not null)
     */
    @Test
    public void selectByWapper5() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("gna", "王");
        queryWrapper.or(qw -> qw.lt("age", 40).or().isNotNull("mail"));

        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 姓王或(年龄小于40且大于20且邮箱不为空)
     * gna like '王%' or (age < 40 and age > 20 and mail is not null)
     */
    @Test
    public void selectByWapper6() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("gna", "王");
        queryWrapper.and(qw -> qw.lt("age", 40).gt("age", 20).isNotNull("mail"));

        List<StudBean> studBeanList = studMapper.selectList(queryWrapper);
        logger.info("===================================================");
        studBeanList.forEach(stud -> {
            logger.info(stud.toString());
        });
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        QueryWrapper<StudBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gna", "明");
        queryWrapper.le("age", 30);

        Page<StudBean> page = new Page<StudBean>(1, 2);

        IPage<StudBean> iPage = studMapper.selectPage(page, queryWrapper);
        logger.info("===================================================");
        logger.info("总页数:"+iPage.getPages());
        logger.info("总记录数:"+iPage.getTotal());
        iPage.getRecords().forEach(studBean -> {
            logger.info(studBean.toString());
        });
    }



}
