package com.lgy.common.rabbitMQ;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitRabbitMQ {

    @Autowired
    AmqpAdmin amqpAdmin;

    public void createExchange() {

        //声明创建一个交换器
        amqpAdmin.declareExchange(new DirectExchange(RabbitMQConfig.AMQPADMIN_EXCHANGE));
        //声明创建一个队列
        amqpAdmin.declareQueue(new Queue(RabbitMQConfig.AMQPADMIN_QUEUE, true));
        //声明绑定
        amqpAdmin.declareBinding(new Binding(RabbitMQConfig.AMQPADMIN_QUEUE, Binding.DestinationType.QUEUE,
                RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, null));

    }

}
