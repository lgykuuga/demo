package com.lgy.demo.service.impl;


import com.lgy.common.service.impl.AbstractServiceImpl;
import com.lgy.demo.bean.oms_order.OrderEvent;
import com.lgy.demo.service.IOrderEventService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderEventServiceImpl extends AbstractServiceImpl<OrderEvent> implements IOrderEventService {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RabbitTemplate rabbitTemplate;

}
