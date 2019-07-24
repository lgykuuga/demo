package com.lgy.demo.service.impl;


import com.lgy.common.config.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import com.lgy.demo.mapper.DemoMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Resource
    DemoMapper demoMapper;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Override
    public int insertDemo(DemoBean demoBean) {
        return demoMapper.insertDemo(demoBean);
    }

    @Override
    public int deleteDemo(int id) {
        return demoMapper.deleteDemo(id);
    }

    @Override
    public int updateDemo(DemoBean demoBean) {
        return demoMapper.updateDemo(demoBean);
    }

    @Override
    public DemoBean queryDemoById(int id) {
        return demoMapper.queryDemoById(id);
    }

    @Override
    public List<DemoBean> queryAll() {
        return demoMapper.queryAll();
    }

    @Override
    public int setRedis(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return 1;
        } catch (Exception e) {
            System.out.println("setRedis Exception:" + e);
        }
        return 0;
    }

    @Override
    public String getRedis(String key) {
        try {
            String value = (String) redisTemplate.opsForValue().get(key);
            return value;
        } catch (Exception e) {
            System.out.println("getRedis Exception:" + e);
        }
        return "";
    }

    /**
     * 监听amqpAdmin.queue队列
     */
    @Override
    @RabbitListener(queues = RabbitMQConfig.AMQPADMIN_QUEUE)
    public void rabbitMQListener(DemoBean demoBean) {
        System.out.println("来监听amqpAdmin.queue");
    }

    /**
     * 手动触发AmqpAdminProcuder
     */
    @Override
    public void handAmqpAdminProcuder(String gco) {
        DemoBean demoBean = this.factory();
        if (!StringUtils.isEmpty(gco)) {
            demoBean.setGco(gco);
            //对象默认被序列化发出去,后根据messageConverter配置把序列化改成Json格式
            rabbitTemplate.convertAndSend(RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, demoBean);
        } else {
            return;
        }
    }

    @Override
    public DemoBean factory() {
        //TODO 获取当前对象,设置创建人
        DemoBean demoBean = new DemoBean();
        demoBean.setCrco("Task");
        demoBean.setCrna("XXL-JOB-Task");
        demoBean.setCrdt(System.currentTimeMillis());
        return demoBean;
    }
}
