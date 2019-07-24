package com.lgy.demo.rabbitMQ;

import com.lgy.common.config.rabbitMQ.RabbitMQConfig;
import com.lgy.demo.bean.DemoBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /** 发送Message到交换器中,交换器根据Routing key找到binding发送至对应的queue中 */
    @Test
    public void convertAndSend() {

        DemoBean demoBean = new DemoBean();
        demoBean.setGco("aaa");
        demoBean.setGna("bbb");
        demoBean.setCrco("RabbitMQTest");
        demoBean.setCrna("RabbitMQ测试");
        demoBean.setCrdt(System.currentTimeMillis());
        //对象默认被序列化发出去,后根据messageConverter配置把序列化改成Json格式
        rabbitTemplate.convertAndSend(RabbitMQConfig.AMQPADMIN_EXCHANGE, RabbitMQConfig.AMQPADMIN_QUEUE, demoBean);
    }

    /** 消费队列里的message */
    @Test
    public void receive() {
        DemoBean demoBean = (DemoBean) rabbitTemplate.receiveAndConvert(RabbitMQConfig.AMQPADMIN_QUEUE);
        System.out.println(demoBean.toString());
    }


}
