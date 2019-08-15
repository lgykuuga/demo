package com.lgy.demo.bean.oms_order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

/**
 * 订单支付信息
 */

public class OrderPayBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    /** 内部订单号 key  */
    private String biid;
    /** 外部订单号  */
    private String soid;

    /** 订单运费 */
    private BigDecimal shipping_fee;
    /** 订单总金额 */
    private BigDecimal order_price;
    /** 订单实付金额 */
    private BigDecimal order_payment;
    /** 实收金额 */
    private BigDecimal net;
    /** 订单优惠金额（不包含产品优惠）*/
    private BigDecimal discount_fee;
    /** 关税 */
    private BigDecimal tariff;
    /** 订单费用明细 */
    private BigDecimal amount_info;
    /** 付款时间 */
    private String received_date;

/*
*    TODO 待定字段
*    /** 订单付款状态 1:未付款 2:部分付款 3:完全付款 *//*
    private String payment_status;
    *//** 付款方式[1,paypal 2,gc 3,boleto 4,giftcard 5,西联
     6,信用卡 7,银行转账 8,其他 9,预付款,10,余额] *//*
    private String payment_type;
    *//** 付款ID *//*
    private String transaction_id;
    *//** 付款币种 *//*
    private String currency;
    *//** 付款金额(本地币) *//*
    private BigDecimal total;
    *//** 付款金额(US) *//*
    private BigDecimal total_us;
    *//** 手续费 *//*
    private BigDecimal fee;
    *//** 付款账号 *//*
    private String from_email;
    *//** 佣金(为客户账户做推广，所获得的返利) *//*
    private BigDecimal rebate_fee;
    *//** 支付方式(wordpay) *//*
    private String pay_method;

    */


}
