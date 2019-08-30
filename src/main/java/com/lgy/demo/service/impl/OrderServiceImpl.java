package com.lgy.demo.service.impl;


import com.lgy.common.config.incrementer.IDIncrementer;
import com.lgy.common.service.impl.AbstractServiceImpl;
import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.enums.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractServiceImpl<OrderBean> implements IOrderService {

    @Autowired
    IDIncrementer idIncrementer;

    private static final String MOID = "ODMA";

    @Override
    public OrderBean factory(OrderBean order) {
        //TODO 获取当前对象,设置创建人
        order.setCrco("Task");
        order.setCrna("XXL-JOB-Task");
        order.setCrdt(System.currentTimeMillis());
        return order;
    }

    @Override
    public Message updateOrderFlag(OrderBean order, OrderFlagEnum orderFlagEnum) {
        logger.info("订单[{}]更新状态为[{}]", order.getBiid(), orderFlagEnum.getValue());
        order.setFlag(orderFlagEnum.getKey());
        order.setUpdt(System.currentTimeMillis());
        Integer i = this.updateByBiid(order);
        if (i == 1) {
            return new Message("更新订单状态成功", true);
        }
        return new Message( "更新订单状态失败", false);
    }

    @Override
    public Integer save(OrderBean orderBean) {
        orderBean.setBiid(idIncrementer.getNextId(MOID));
        return super.save(orderBean);
    }
}
