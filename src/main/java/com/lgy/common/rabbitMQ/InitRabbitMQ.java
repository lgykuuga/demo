package com.lgy.common.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitRabbitMQ {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AmqpAdmin amqpAdmin;

    public void createExchange() {

        logger.info("初始化RabbitMQ配置");

        //声明创建一个交换器
        amqpAdmin.declareExchange(new DirectExchange(RabbitMQConfig.AMQPADMIN_EXCHANGE));
        //声明创建一个队列
        amqpAdmin.declareQueue(new Queue(RabbitMQConfig.AMQPADMIN_QUEUE, true));
        //声明绑定
        amqpAdmin.declareBinding(new Binding(RabbitMQConfig.AMQPADMIN_QUEUE, Binding.DestinationType.QUEUE,
                RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, null));

    }

}
