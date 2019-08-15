package com.lgy.demo.service;

import com.lgy.common.service.AbstractService;
import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.pattern.OrderFlagEnum;

public interface IOrderService extends AbstractService<OrderBean> {


    OrderBean factory(OrderBean order);

    /**
     * 更新订单状态
     * @param order
     * @param flag
     * @return
     */
    Message updateOrderFlag(OrderBean order, OrderFlagEnum flag);

}
