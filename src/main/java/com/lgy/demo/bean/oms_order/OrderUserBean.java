package com.lgy.demo.bean.oms_order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

/**
 * 订单买家信息
 */
public class OrderUserBean extends AbstractBean {

    private static final long serialVersionUID = 1L;
    /** 内部订单号 key */
    private String biid;
    /** 外部订单号  */
    private String soid;

    /** 买家账号 */
    private String buyer_account;
    /** 买家昵称 */
    private String buyer_nick;
    /** 买家姓名 */
    private String buyer_name;
    /** 买家电话 */
    private String buyer_mobile;
    /** 买家身份证号 */
    private String buyer_idcard;
    /** 买家邮件地址 */
    private String buyer_email;

    /** 买家留言 */
    private String buyer_memo;
    /** 卖家留言 */
    private String seller_memo;

    /** 收货人的姓名 */
    private String receiver_name;
    /** 收货人国籍 */
    private String receiver_country;
    /** 收货人的所在省份 */
    private String receiver_state;
    /** 收货人的所在城市 */
    private String receiver_city;
    /** 收货人街道地址 */
    private String receiver_town;
    /** 收货人的详细地址 */
    private String receiver_address;
    /** 收货人的详细地址2 */
    private String receiver_address2;
    /** 收货人的详细地址3 */
    private String receiver_addres3;
    /** 收货人的邮编 */
    private String receiver_zip;
    /** 收货人的手机号码 */
    private String receiver_mobile;
    /** 收货人的电话号码 */
    private String receiver_phone;
    /** 收货人的邮件地址 */
    private String receiver_email;


    /**
     * TODO 待定字段
     * 收件人国家编码、省份/洲编码、城市编码、区编码
     * `user_language` varchar(10) NOT NULL DEFAULT '' COMMENT '用户浏览语种',
     * `customer_id` int(11) NOT NULL DEFAULT '0' COMMENT 'oms顾客id',
     *  `customer_level_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '客户级别',
     *  `customer_zone_id` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '顾客区域ID@@@',
     *   `customer_lang_id` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '顾客语种表@@@',
     * `address_status` varchar(100) NOT NULL DEFAULT '' COMMENT '地址状态',
     */


}
