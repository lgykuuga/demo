package com.lgy.demo.service.impl;


import com.lgy.common.config.rabbitMQ.RabbitMQConfig;
import com.lgy.common.service.impl.AbstractServiceImpl;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl  extends AbstractServiceImpl<DemoBean> implements IDemoService {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RabbitTemplate rabbitTemplate;

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
    public void handAmqpAdminProcuder(DemoBean demoBean) {
        demoBean = this.factory(demoBean);
        if (!StringUtils.isEmpty(demoBean.getGco())) {
            //对象默认被序列化发出去,后根据messageConverter配置把序列化改成Json格式
            rabbitTemplate.convertAndSend(RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, demoBean);
        } else {
            return;
        }
    }

    @Override
    public DemoBean factory(DemoBean demoBean) {
        //TODO 获取当前对象,设置创建人
        demoBean.setCrco("Task");
        demoBean.setCrna("XXL-JOB-Task");
        demoBean.setCrdt(System.currentTimeMillis());
        return demoBean;
    }
}
