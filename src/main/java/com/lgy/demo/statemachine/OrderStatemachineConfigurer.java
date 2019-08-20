package com.lgy.demo.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class OrderStatemachineConfigurer extends EnumStateMachineConfigurerAdapter<OrderStateEnum, OrderEventEnum> {

    /**
     * configure(StateMachineConfigurationConfigurer<States, Events> config)方法为当前的状态机指定了状态监听器，
     * 其中listener()则是调用了下一个内容创建的监听器实例，用来处理各个各个发生的状态迁移事件。
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStateEnum, OrderEventEnum> config) throws Exception {
        super.configure(config);
    }

    /**
     * configure(StateMachineStateConfigurer<States, Events> states)方法用来初始化当前状态机拥有哪些状态，
     * 其中initial(States.UNPAID)定义了初始状态为UNPAID，
     * states(EnumSet.allOf(States.class))则指定了使用上一步中定义的所有状态作为该状态机的状态定义。
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStateEnum, OrderEventEnum> states) throws Exception {
        states
                .withStates()
                // 初识状态：Locked
                .initial(OrderStateEnum.ORDER_NEW)
                .states(EnumSet.allOf(OrderStateEnum.class));
    }


    /**
     * configure(StateMachineTransitionConfigurer<States, Events> transitions)方法用来初始化当前状态机有哪些状态迁移动作，
     * 其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStateEnum, OrderEventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(OrderStateEnum.ORDER_NEW).target(OrderStateEnum.ORDER_AUDIT)
                .event(OrderEventEnum.AUDIT_ORDER)
                .and()
                .withExternal()
                .source(OrderStateEnum.ORDER_AUDIT).target(OrderStateEnum.ORDER_DISTRIBUTION)
                .event(OrderEventEnum.DISTRIBUTION_ORDER);
    }

    @Bean
    public StateMachineListener<OrderStateEnum, OrderEventEnum> listener() {
        return new StateMachineListenerAdapter<OrderStateEnum, OrderEventEnum>() {

            @Override
            public void transition(Transition<OrderStateEnum, OrderEventEnum> transition) {

                if(transition.getSource().getId() == OrderStateEnum.ORDER_NEW
                        && transition.getTarget().getId() == OrderStateEnum.ORDER_AUDIT) {
                    System.out.println("订单完成保存，待审核");
                    return;
                }

                if(transition.getSource().getId() == OrderStateEnum.ORDER_AUDIT
                        && transition.getTarget().getId() == OrderStateEnum.ORDER_DISTRIBUTION) {
                    System.out.println("订单完成审核，待配货");
                    return;
                }
            }

        };
    }

}
