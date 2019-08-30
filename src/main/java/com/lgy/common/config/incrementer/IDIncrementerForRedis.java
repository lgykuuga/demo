package com.lgy.common.config.incrementer;

import com.lgy.common.config.redis.RedisDAO;
import com.lgy.common.util.SimpleDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 分布式部署支持redis.
 * <p>ID生成器，在存储bean时生成ID.
 *
 *  <p>说明：
 *      <p>1.每天凌晨23点59分59秒更新日期.
 *      <p>2.年月日的字符串不区分字母大小写，但要求格式：前缀[年][月][日][ID00000]，其中00000为格式，示例：TT[yY][Mm][Dd][id000].
 */
@Component(value="idIncrementerForRedis")
public class IDIncrementerForRedis {

    /** 多租户 redis 生成流水单号*/
    public static final String ID_INCREMENTER_INITIALIZER = "ID_INCR_INIT";

    @Autowired(required=false)
    private RedisDAO redisDAO;

    public IDIncrementerForRedis(){

    }

    /**
     * 获取当前ID值。最终的结果是：prefix + ymd + idFormat生成的结果。
     *
     * @param moid 模块编码
     * @return String
     * @throws DataAccessException 。
     */
    public String getNextId(String moid) {

        String nextId = getByRedis(moid);
        if(nextId != null){
            return nextId;
        }else{
            return "redis获取ID出错.";
        }
    }

    /**
     * 基于redis生成
     * 生成的key 加了年月日 如:ID_INCR_INIT_2018-08-09_101
     * @param moid 模块编码
     * @return String
     */
    private String getByRedis(String moid){
        //1.获取序号
        IDIncrementerBean idb = IDIncrementerInitializer.IDMODE.get(moid);
        if(idb != null){
            String dataStr = SimpleDateUtils.toDate(new Date());
            String key = ID_INCREMENTER_INITIALIZER+"_"+dataStr;
            Long number = redisDAO.hmIncrBy(key, moid, 1L);

            if(number == 1){
                // 设置过期时间   当key过期时，重新加载并设置过期时间，再加 10分钟 防止切换时出错
                Long expireTime = SimpleDateUtils.getBeforeDayConvertSecond()+600;
                redisDAO.expire(key, expireTime);
            }

            if(number != null && number >0){
                return idb.getNextFormatID(number);
            }
        }
        return null;
    }

}
