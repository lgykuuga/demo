package com.lgy.common.config.incrementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "idIncrementer")
public class IDIncrementerImpl implements IDIncrementer {

    @Autowired
    private IDIncrementerInitializer idIncrementerInitializer;
    @Autowired
    private IDIncrementerForRedis idIncrementerForRedis;

    @Override
    public String getNextId(String moid) {

        // 生成规则为空
        if (IDIncrementerInitializer.IDMODE.isEmpty()) {
            idIncrementerInitializer.initializer();
        }

        // 正常业务
        return idIncrementerForRedis.getNextId(moid);
    }
}
