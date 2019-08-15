package com.lgy.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

public class TradeBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    /** 门店自提，总店发货，分店取货的门店自提订单标识 */
    private String shop_pick;
    /** 预售单为true，否则false */
    private String new_presell;
    /** 交易编号  */
    private String tid ;
    /** 交易状态。可选值: * TRADE_NO_CREATE_PAY(没有创建支付宝交易) * WAIT_BUYER_PAY(等待买家付款) * SELLER_CONSIGNED_PART(卖家部分发货) * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) * TRADE_BUYER_SIGNED(买家已签收,货到付款专用) * TRADE_FINISHED(交易成功) * TRADE_CLOSED(付款以后用户退款成功，交易自动关闭) * TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易) * PAY_PENDING(国际信用卡支付付款确认中) * WAIT_PRE_AUTH_CONFIRM(0元购合约中) * PAID_FORBID_CONSIGN(拼团中订单或者发货强管控的订单，已付款但禁止发货) */
    private String status;
    /** 交易创建时间。格式:yyyy-MM-dd HH:mm:ss */
    private String created;
    /** 付款时间。格式:yyyy-MM-dd HH:mm:ss。订单的付款时间即为物流订单的创建时间。 */
    private String pay_time;
    /** 交易修改时间(用户对订单的任何修改都会更新此字段)。格式:yyyy-MM-dd HH:mm:ss */
    private String modified;
    /** 交易结束时间。交易成功时间(更新交易状态为成功的同时更新)/确认收货时间或者交易关闭时间 。格式:yyyy-MM-dd HH:mm:ss */
    private String end_time;

    /** 买家留言 */
    private String buyer_message;
    /** 买家备注（与淘宝网上订单的买家备注对应，只有买家才能查看该字段） */
    private String buyer_memo;
    /** 卖家备注（与淘宝网上订单的卖家备注对应，只有卖家才能查看该字段） */
    private String seller_memo;
    /** 卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5 */
    private String seller_flag;
    /** 买家昵称 */
    private String buyer_nick;
    /** 收货人的姓名 */
    private String receiver_name;
    /** 收货人的所在省份 */
    private String receiver_state;
    /** 收货人的详细地址 */
    private String receiver_address;
    /** 收货人的邮编 */
    private String receiver_zip;
    /** 收货人的手机号码 */
    private String receiver_mobile;
    /** 收货人的电话号码 */
    private String receiver_phone;
    /** 收货人国籍 */
    private String receiver_country;
    /** 收货人街道地址 */
    private String receiver_town;


    /** 卖家发货时间。 */
    private String consign_time;
    /** 商家的预计发货时间。 */
    private String est_con_time;

    /** 卖家实际收到的支付宝打款金额（由于子订单可以部分确认收货，这个金额会随着子订单的确认收货而不断增加，交易成功后等于买家实付款减去退款金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分 */
    private BigDecimal received_payment;
    /** 实付金额 */
    private BigDecimal payment;
    /** 邮费 */
    private BigDecimal post_fee;
    /** 天猫国际官网直供主订单关税税费 */
    private BigDecimal order_tax_fee;
    /** 满返红包的金额；如果没有满返红包，则值为 0.00 */
    private BigDecimal paid_coupon_fee;
    /** 商品价格。精确到2位小数；单位：元。如：200.07，表示：200元7分 */
    private BigDecimal price;
    /** 可以使用trade.promotion_details查询系统优惠系统优惠金额（如打折，VIP，满就送等），精确到2位小数，单位：元。如：200.07，表示：200元7分 */
    private BigDecimal discount_fee;
    /** 是否包含邮费。与available_confirm_fee同时使用。可选值:true(包含),false(不包含) */
    private BigDecimal has_post_fee;
    /** 商品金额（商品价格乘以数量的总金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分 */
    private BigDecimal total_fee;

    /** 买家货到付款服务费。精确到2位小数;单位:元。如:12.07，表示:12元7分 */
    private BigDecimal buyer_cod_fee;
    /** 卖家手工调整金额，精确到2位小数，单位：元。如：200.07，表示：200元7分。来源于订单价格修改，如果有多笔子订单的时候，这个为0，单笔的话则跟[order].adjust_fee一样 */
    private BigDecimal adjust_fee;



}
