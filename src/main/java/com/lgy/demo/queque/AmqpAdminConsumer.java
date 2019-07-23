package com.lgy.demo.queque;

import com.lgy.common.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * rabbitMQ amqpAdmin消息队列的消费者,保存在数据库中。
 */
@Service
public class AmqpAdminConsumer {

    @Resource
    IDemoService demoService;

    @Resource
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQConfig.AMQPADMIN_QUEUE)
    public void receive(DemoBean demoBean) {
        System.out.println("监听到amqpAdmin.queue消息,保存demoBean");
        if (demoBean != null) {
            demoService.insertDemo(demoBean);
            System.out.println("保存demoBean成功");
        } else {
            System.out.println("demoBean为空");
        }

    }

}
