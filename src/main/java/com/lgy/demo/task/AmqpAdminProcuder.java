package com.lgy.demo.task;

import com.lgy.common.config.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IDemoService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 用xxl-job作为rabbitMQ amqpAdmin消息队列的生产者
 */
@JobHandler(value="amqpAdminProcuderHandler")
@Component
public class AmqpAdminProcuder extends IJobHandler {

	@Resource
	IDemoService demoService;
	@Resource
	RabbitTemplate rabbitTemplate;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("AmqpAdminProcuder, param:" + param);
		DemoBean demoBean = demoService.factory(new DemoBean());
		demoBean.setGco("" + Math.random()* 100);
		//对象默认被序列化发出去,后根据messageConverter配置把序列化改成Json格式
		rabbitTemplate.convertAndSend(RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, demoBean);

		return SUCCESS;
	}

}
