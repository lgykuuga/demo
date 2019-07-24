package com.lgy.common.config.rabbitMQ;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /** demo: 由amqpAdmin生成的交换器 */
    public static final String AMQPADMIN_EXCHANGE = "amqpAdmin.exchange";
    /** demo: 由amqpAdmin生成的队列 */
    public static final String AMQPADMIN_QUEUE = "amqpAdmin.queue";

    /**
     * 将Message由序列化结果转化为Json数据。
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
