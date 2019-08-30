package com.lgy.common.config.incrementer;

public interface IDIncrementer {

    /**
     * 获取下一个ID
     * @param moid 模块名称
     * @return 订单号
     */
    String getNextId(String moid);
}
