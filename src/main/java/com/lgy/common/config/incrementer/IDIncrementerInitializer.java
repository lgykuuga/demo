package com.lgy.common.config.incrementer;

import com.lgy.common.config.redis.RedisDAO;
import com.lgy.common.config.system.SpringToolStateUtil;
import com.lgy.common.util.SimpleDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component(value = "idIncrementerInitializer")
public class IDIncrementerInitializer {

    /** 多租户 redis 生成流水单号*/
    public static final String ID_INCREMENTER_INITIALIZER = "ID_INCR_INIT";

    /**
     * 每个模块一个内部对象
     */
    public static Map<String, IDIncrementerBean> IDMODE = Collections
            .synchronizedMap(new HashMap<String, IDIncrementerBean>(128));

    @Autowired
    private IDIncrementerForDB idIncrementerForDB;

    @Autowired(required = false)
    private RedisDAO redisDAO;


    /**
     * 初始化方法
     * synchronized 和 if 双重验证，防并发重复初始化
     */
    public synchronized void initializer() {

        // 双重验证，防并发重复初始化
        if (!IDMODE.isEmpty()) {
            return;
        }
        // 初始化mode
        initIDMode();
        if (!SpringToolStateUtil.isREDIS_STATE()) {
            initIDbyMysql();
        }
    }

    /**
     * 重新全量初始化
     * @param cid 客户ID
     */
    public synchronized void reload(String cid) {

        // 初始化mode
        IDMODE.clear();
        initIDMode();
        //用redis获取ID or DB获取ID
        if (SpringToolStateUtil.isREDIS_STATE() == true) {
            removeIDbyRedis(cid);
            initIDbyRedis(cid);
        } else {
            initIDbyMysql();
        }
    }

    /**
     * 基于mysql生成ID
     */
    private void initIDMode() {
        idIncrementerForDB.initIDMode(IDMODE);
    }

    /**
     * 基于mysql生成ID
     */
    public void initIDbyMysql() {
        idIncrementerForDB.initIDbyMysql();
    }

    /**
     * 基于redis生成ID
     * @param cid 客户ID
     */
    private void initIDbyRedis(String cid) {

        Set<String> keys = IDMODE.keySet();
        for (String key : keys) {
            if (redisDAO.hmExists(ID_INCREMENTER_INITIALIZER + "_" + cid, key) == false) {
                redisDAO.hmset(ID_INCREMENTER_INITIALIZER + "_" + cid, key, "0");
            }
        }

        //XXX  YK  全新设计下,这里不严谨. 每台服务器的时间可能不一样,相差几秒很正常.这里会重复设置,就会导致在凌晨时候生成单号重复.
        // 设置过期时间
        Long expireTime = SimpleDateUtils.getBeforeDayConvertSecond();
        redisDAO.expire(ID_INCREMENTER_INITIALIZER + "_" + cid, expireTime);
    }

    /**
     * 移除指定的cid redis生成ID
     * @param cid 客户ID
     */
    private void removeIDbyRedis(String cid) {
        redisDAO.delete(ID_INCREMENTER_INITIALIZER + "_" + cid);
    }
}
