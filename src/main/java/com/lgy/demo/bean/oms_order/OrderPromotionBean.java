package com.lgy.demo.bean.oms_order;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description: 优惠信息表
 * @author LGy  
 */
public class OrderPromotionBean extends AbstractBean {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal discount_fee;//优惠金额
	private String promotion_name;//优惠信息名称
	private String gift_item_name;//满就送商品时，所送商品的名称
	private String gift_item_id;//赠品的宝贝id
	private Integer gift_item_num;//满就送礼物的礼物数量
	private Integer promotion_desc;//优惠活动的描述
	private Integer promotion_id;//优惠id，(由营销工具id、优惠活动id和优惠详情id组成，结构为：营销工具id-优惠活动id_优惠详情id，如mjs-123024_211143）

	


}
