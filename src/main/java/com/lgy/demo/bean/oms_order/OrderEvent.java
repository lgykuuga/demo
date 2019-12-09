package com.lgy.demo.bean.oms_order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;

/**
 * 订单明细信息
 */

@TableName("oms_event")
public class OrderEvent extends AbstractBean {

    private static final long serialVersionUID = 1L;

    private Integer flag;//订单节点状态 OrderFlagEnum
    private Integer type;//订单类型(1:一单一货/2:一单多货/3:大单)   OrderQtyEnum
    private Integer stat;//订单状态(0:取消/1:有效/2:被合并/3:被拆分)  OrderStatusEnum
    private Integer chan;//渠道
    private Integer payt;//结算方式
    private Integer delt;//发货类型
    private Integer stru;//订单结构类型
    private Integer trad;//贸易类型
    private Integer plat;//平台类型
    private Integer even;//订单行为

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getChan() {
        return chan;
    }

    public void setChan(Integer chan) {
        this.chan = chan;
    }

    public Integer getPayt() {
        return payt;
    }

    public void setPayt(Integer payt) {
        this.payt = payt;
    }

    public Integer getDelt() {
        return delt;
    }

    public void setDelt(Integer delt) {
        this.delt = delt;
    }

    public Integer getStru() {
        return stru;
    }

    public void setStru(Integer stru) {
        this.stru = stru;
    }

    public Integer getTrad() {
        return trad;
    }

    public void setTrad(Integer trad) {
        this.trad = trad;
    }

    public Integer getPlat() {
        return plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public Integer getEven() {
        return even;
    }

    public void setEven(Integer even) {
        this.even = even;
    }
}
