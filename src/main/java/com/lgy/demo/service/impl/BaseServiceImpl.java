package com.lgy.demo.service.impl;


import com.lgy.common.rabbitMQ.RabbitMQConfig;
import com.lgy.common.service.AbstractServiceImpl;
import com.lgy.demo.bean.BaseBean;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.mapper.DemoMapper;
import com.lgy.demo.service.IBaseService;
import com.lgy.demo.service.IDemoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BaseServiceImpl extends AbstractServiceImpl<BaseBean> implements IBaseService {

}
