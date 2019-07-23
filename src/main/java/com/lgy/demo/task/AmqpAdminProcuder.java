package com.lgy.demo.task;

import com.lgy.common.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * 用xxl-job作为rabbitMQ amqpAdmin消息队列的生产者
 */
@JobHandler(value="amqpAdminProcuderHandler")
@Component
public class AmqpAdminProcuder extends IJobHandler {

	@Resource
	RabbitTemplate rabbitTemplate;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("AmqpAdminProcuder, param:" + param);

		DemoBean demoBean = new DemoBean();
		demoBean.setName("aaa");
		demoBean.setValue("bbb");
		demoBean.setCrco("Task");
		demoBean.setCrna("XXL-JOB-Task");
		demoBean.setCrdt(System.currentTimeMillis());
		//对象默认被序列化发出去,后根据messageConverter配置把序列化改成Json格式
		rabbitTemplate.convertAndSend(RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, demoBean);

		return SUCCESS;
	}

}
