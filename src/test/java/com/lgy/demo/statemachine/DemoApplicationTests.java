package com.lgy.demo.statemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private StateMachine<OrderStateEnum, OrderEventEnum> stateMachine;

    @Test
    public void contextLoads() {
        stateMachine.start();
        System.out.println("新增成功");
        stateMachine.sendEvent(OrderEventEnum.AUDIT_ORDER);
    }

}
