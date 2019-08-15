package com.lgy.demo.pattern.flagStateService;

import com.lgy.demo.pattern.AbstractOrderFlag;
import com.lgy.demo.pattern.OrderFlag;

public class OrderEvent {

    OrderFlag orderFlag = null;

    //定义各种状态
    AbstractOrderFlag waitingPay = new OrderNewService(this);
    AbstractOrderFlag waitingSend = new OrderAuditService(this);
    AbstractOrderFlag deliver = new OrderDistributionService(this);
    AbstractOrderFlag tradeComplete = new OrderSendService(this);
    AbstractOrderFlag afterSale = new OrderSendOutService(this);
    AbstractOrderFlag tradeClose = new OrderCancelService(this);


    public OrderEvent() {

    }




}
