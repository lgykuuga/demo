package com.lgy.demo.bean.oms_order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

/**
 * 订单明细信息
 */


public class OrderDetailBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    /** 内部订单号 key  */
    private String biid;
    /** 外部订单号  */
    private String soid;
    /** 子订单号  */
    private String child_out_order_sn;
    /** 行序号  */
    private String roid;

    /** 产品编码 */
    private String goods_sn;
    /** 产品名称 */
    private String goods_name;
    /** 产品图片 */
    private String goods_img;

    /** 网站销售单价 */
    private BigDecimal unit_goods_ori_price;
    /** 产品单价(打折后) */
    private BigDecimal unit_goods_price;
    /** 是否免邮0否1是 */
    private Integer is_free_shipping;
    /** 运费 */
    private BigDecimal discount_shipping_fee;

    /** 产品购买数量 */
    private Integer goods_quantity;
    /** 发货数量 */
    private Integer deliver_quantity;
    /** 已配货数量 */
    private Integer assmbly_quantity;
    /** 退款数量 */
    private Integer refund_quantity;
    /** 是否已经发完货，0不是，1已经完全发出 */
    private Integer is_finish_deliver;

    /** 产品的重量 */
    private BigDecimal goods_weight;

    /** 销售类型(1:预售  2:预定) */
    private String is_booking;
    /** 产品等级 */
    private String goods_grade;
    /** 产品类型 */
    private String goods_type;


}
