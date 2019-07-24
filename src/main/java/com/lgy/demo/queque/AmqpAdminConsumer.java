package com.lgy.demo.queque;

import com.lgy.common.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    IDemoService demoService;

    @Resource
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQConfig.AMQPADMIN_QUEUE)
    public void receive(DemoBean demoBean) {
        logger.info("监听到amqpAdmin.queue消息,保存demoBean:[{}]", demoBean.toString());
        if (demoBean != null) {
            demoService.insertDemo(demoBean);
            logger.info("保存[{}]成功", demoBean.toString());
        } else {
            logger.error("demoBean为空");
        }

    }

}
