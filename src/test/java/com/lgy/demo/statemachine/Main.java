package com.lgy.demo.statemachine;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderFSM fsm = OrderFSM.init(
                new OrderFSMContextData(
                        true, true, false, true))
                .fire(OrderFSM.FSMEvent.ORDER_CREATE);
    }
}
