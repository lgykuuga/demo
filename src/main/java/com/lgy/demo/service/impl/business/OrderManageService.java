package com.lgy.demo.service.impl.business;

import com.lgy.common.util.Message;
import com.lgy.demo.bean.oms_order.OrderBean;
import com.lgy.demo.enums.OrderChannelEnum;
import com.lgy.demo.enums.OrderFlagEnum;
import com.lgy.demo.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 订单管理服务
 */
@Service
public class OrderManageService {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    IOrderService orderService;

    /**
     * 处理对应业务
     * @param biid 单号
     * @param flag 更新节点状态
     */
    public void process(String biid, OrderFlagEnum flag) {

        OrderBean order = null;

        if (flag == OrderFlagEnum.ORDER_NEW) {
            order = new OrderBean();
            order.setBiid(biid);
            order.setFlag(flag.getKey());
            orderService.save(order);
        } else {
            order = orderService.findOne("biid", biid);
            if (order == null) {
                logger.error("找不到订单[{}]", biid);
                return;
            }

            Message message = orderService.updateOrderFlag(order, flag);
            if (!message.isStatus()) {
                logger.error("更新订单[{}]状态失败", biid);
                return;
            }
        }

        //TODO 事件存入在数据库中。
        switch (flag) {
            case ORDER_NEW:
                //匹配动作
                audit(order);
                break;
            case ORDER_AUDIT:
                //配货动作
                distribution(order);
                break;
            case ORDER_DISTRIBUTION:
                //推送动作
                pushOrder(order);
                break;
            case ORDER_SENDOUT:
                //完成动作
                complete(order);
                break;
            case ORDER_CANCEL:
                //取消动作
                cancel(order);
                break;
            default :
                logger.error("没有定义行为");
        }
    }

    private void cancel(OrderBean order) {
        logger.info("订单[{}]加入取消MQ", order.getBiid());
    }

    private void complete(OrderBean order) {
        logger.info("订单[{}]加入发货完成MQ", order.getBiid());
    }

    private void pushOrder(OrderBean order) {
        logger.info("订单[{}]加入推送MQ", order.getBiid());
    }

    private void distribution(OrderBean order) {
        logger.info("订单[{}]加入配货MQ", order.getBiid());
    }

    private void audit(OrderBean order) {
        //渠道为外部,直接配货
        if (OrderChannelEnum.EXTERNAL.getKey().equals(order.getChan())) {
            distribution(order);
        } else {
            logger.info("订单[{}]加入匹配MQ", order.getBiid());
        }
    }

}
