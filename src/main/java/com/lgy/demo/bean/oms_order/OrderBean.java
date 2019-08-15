package com.lgy.demo.bean.oms_order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单明细信息
 */

@TableName("oms_order")
public class OrderBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    private String biid;/** 内部订单号 key  */
    private String soid;/** 外部订单号  */
    private String shco;//店铺编码
    private String whco;//仓库编码
    private String lpco;//物流商编码
    private String loid;//快递单号
    private Integer type;//订单类型(1:一单一货/2:一单多货/3:大单)   OrderQtyEnum
    private Integer stat;//订单状态(0:取消/1:有效/2:被合并/3:被拆分)  OrderStatusEnum
    private Integer flag;//订单节点状态

//    /** 订单买家信息 */
//    @Transient
//    OrderUserBean orderUser;
//
//    /** 订单支付信息 */
//    @Transient
//    OrderPayBean orderPay;
//    /** 订单明细信息 */
//    @Transient
//    List<OrderDetailBean> orderDetails;

    public String getBiid() {
        return biid;
    }

    public void setBiid(String biid) {
        this.biid = biid;
    }

    public String getSoid() {
        return soid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public String getShco() {
        return shco;
    }

    public void setShco(String shco) {
        this.shco = shco;
    }

    public String getWhco() {
        return whco;
    }

    public void setWhco(String whco) {
        this.whco = whco;
    }

    public String getLpco() {
        return lpco;
    }

    public void setLpco(String lpco) {
        this.lpco = lpco;
    }

    public String getLoid() {
        return loid;
    }

    public void setLoid(String loid) {
        this.loid = loid;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
