package com.lgy.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.elasticsearch.annotations.Document;

@TableName("trace_log")
@Document(indexName = "trace_log")
public class TraceLogBean {

    private static final long serialVersionUID = 1L;

    /**
     * 订单流水编号
     */
    private String orderId;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 内容
     */
    private String content;
    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
