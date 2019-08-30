package com.lgy.common.config.redis;

import com.lgy.common.util.MessageEntity;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public interface RedisDAO {
    /**
     * 获取 RedisTemplate
     *
     * @return RedisTemplate .
     */
    public RedisTemplate<String, Object> getRedisTemplate();

    /**
     * 往通道里发消息
     * @param channel 通道
     * @param message 消息体
     */
    public void sendMessage(String channel, MessageEntity message);

    /**
     * 设置：键 值 例：test 1
     * @param key 键
     * @param value 值
     */
    public void setValue(String key, String value);

    /**
     * 调置key 对应的value和有效时间（秒）
     * @param key 键
     * @param value 值
     * @param seconds 时间（秒）
     */
    public void setValue(String key, String value,Long seconds);

    /**
     * 获取指定key 的 value
     * @param key 键
     * @return String
     */
    public String getValue(String key);


    /**
     * 验证key是否存在
     * @param key 键
     * @return  Boolean
     */
    public Boolean exists(String key);

    /**
     * 设置KEY的有效时长（时间单件秒）
     * 调置key 对应的有效时长
     * @param key 键
     * @param timeout   有效时长
     * @return Boolean
     */
    public Boolean expire(String key, long timeout);

    /**
     * 累加计算（正数为增库存,负数为减库存）
     * 调置key 对应的value
     * @param key 键
     * @param value 值
     * @return  Long
     */
    public Long incrBy(String key,Long value);

    /**
     * hset 累计
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    public Long incrBy(String hkey,String key,Long value);
    /**
     * 删除指定的key
     * @param key 键
     */
    public void delete(String key);

    /**
     * 删除指定的key中的field
     * @param key 键
     */
    public void delete(String key,String... fields);

    /**
     * value将哈希表key中的域field的值设为value
     * @param key HSET key
     * @param field 哈希表key中的域field
     * @param value field的值
     * @return Boolean
     */
    public Boolean hmset(String key,String field,String value);

    /**
     * HGET key field返回哈希表key中给定域field的值。
     *
     * @param key HSET key
     * @param field 哈希表key中的域field
     * @return String
     */
    public String hmget(String key,String field);

    /**
     * hIncrBy key field delta 自增。
     * @param key HSET key
     * @param field 哈希表key中的域field
     * @param value field的值
     * @return String
     */
    public Long hmIncrBy(String key, String field,Long value);
    /**
     * hIncrBy key field 验证hkey 是否存在。
     * @param key HSET key
     * @param field 哈希表key中的域field
     * @return String Boolean
     */
    public Boolean hmExists(String key, String field);

    /**
     * 添加 hmset key value
     * @param hmsetKey  HSET key
     * @param value map
     */
    void put(String hmsetKey,Map<Object,Object> value);

    /**
     * 获取hget对象
     *
     * @param hgetKey HSET key
     * @return  Map
     */
    Map<Object,Object> hmget(String hgetKey);

    /**
     * 设置 hsetKey 下面  key 值
     * @param hsetKey HSET key
     * @param key   哈希表key中的域field
     * @return  Object
     */
    Object hmsetByKey(String hsetKey,String key);
}
