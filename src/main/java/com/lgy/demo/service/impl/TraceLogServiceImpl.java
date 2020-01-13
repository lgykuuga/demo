package com.lgy.demo.service.impl;


import com.lgy.demo.bean.TraceLogBean;
import com.lgy.demo.service.ITraceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceLogServiceImpl implements ITraceLogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<TraceLogBean> getByOrderId(String orderId) {

        Query query = new Query(Criteria.where("orderId").is(orderId));
        List<TraceLogBean> traceLogBeans = mongoTemplate.find(query, TraceLogBean.class);
        return traceLogBeans;
    }
}
