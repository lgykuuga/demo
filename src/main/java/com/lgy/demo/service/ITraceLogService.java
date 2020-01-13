package com.lgy.demo.service;

import com.lgy.demo.bean.TraceLogBean;

import java.util.List;

public interface ITraceLogService  {

    /**
     * 根据单号获取轨迹信息
     *
     * @param orderId 订单号
     * @return
     */
    List<TraceLogBean> getByOrderId(String orderId);
}
