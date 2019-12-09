package com.lgy.common.config.redis;

import com.lgy.common.util.MessageEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * redis操作类
 */
@Service
public class RedisDAOImpl implements RedisDAO {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void sendMessage(String channel, MessageEntity message) {
        redisTemplate.convertAndSend(channel, message);
    }

    @Override
    public void setValue(String key, String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize(key),
                        redisTemplate.getStringSerializer().serialize(value));
                return null;
            }
        });
    }

    @Override
    public void setValue(String key, String value,Long seconds) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyByte = redisTemplate.getStringSerializer().serialize(key);
                connection.set(keyByte,
                        redisTemplate.getStringSerializer().serialize(value));
                return connection.expire(keyByte, seconds);
            }
        });
    }

    @Override
    public String getValue(String key) {

        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] k = redisTemplate.getStringSerializer().serialize(key);
                if (connection.exists(k)) {

                    return redisTemplate.getStringSerializer().deserialize(connection.get(k));
                }
                return null;
            }
        });
    }

    @Override
    public Long incrBy(String key,Long value){

        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.incrBy(redisTemplate.getStringSerializer().serialize(key), value);
            }
        });
    }

    @Override
    public Long incrBy(String hkey,String key,Long value){

        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.hIncrBy(redisTemplate.getStringSerializer().serialize(hkey),
                        redisTemplate.getStringSerializer().serialize(key), value);
            }
        });
    }

    @Override
    public Boolean exists(String key){

        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(redisTemplate.getStringSerializer().serialize(key));
            }
        });
    }

    @Override
    public Boolean expire(String key, long timeout){

        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                return connection.expire(redisTemplate.getStringSerializer().serialize(key), timeout);
            }
        });
        if(obj == null || Boolean.parseBoolean(obj.toString()) == false){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void delete(String key) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) {
                connection.del(redisTemplate.getStringSerializer().serialize(key));
                return null;
            }
        });
    }

    @Override
    public void delete(String key,String... fields) {
        for (String field : fields) {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) {
                    connection.hDel(redisTemplate.getStringSerializer().serialize(key), redisTemplate.getStringSerializer().serialize(field));
                    return null;
                }
            });
        }
    }

    @Override
    public Boolean hmset(String key,String field,String value) {

        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) {
                return connection.hSet(redisTemplate.getStringSerializer().serialize(key)
                        , redisTemplate.getStringSerializer().serialize(field),redisTemplate.getStringSerializer().serialize(value));
            }
        });
        if(obj == null || Boolean.parseBoolean(obj.toString()) == false){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String hmget(String key, String field) {

        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public String doInRedis(RedisConnection connection) {
                byte[] value = connection.hGet(redisTemplate.getStringSerializer().serialize(key)
                        , redisTemplate.getStringSerializer().serialize(field));
                if(value == null){
                    return null;
                }
                return new String(value);
            }
        });
        if(obj != null){
            return obj.toString();
        }else{
            return null;
        }
    }

    @Override
    public Long hmIncrBy(String key, String field,Long delta) {
        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Long doInRedis(RedisConnection connection) {
                Long value = connection.hIncrBy(redisTemplate.getStringSerializer().serialize(key)
                        , redisTemplate.getStringSerializer().serialize(field), delta);

                return value;
            }
        });

        if(obj == null){
            return null;
        }else{
            return Long.parseLong(obj.toString());
        }
    }

    @Override
    public Boolean hmExists(String key, String field) {
        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) {
                return connection.hExists(redisTemplate.getStringSerializer().serialize(key), redisTemplate.getStringSerializer().serialize(field));
            }
        });
        if(obj == null || Boolean.parseBoolean(obj.toString()) == false){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void put(String hsetKey, Map<Object, Object> value) {
        this.redisTemplate.opsForHash().putAll(hsetKey, value);
    }

    @Override
    public Map<Object, Object> hmget(String hgetKey) {
        return this.redisTemplate.opsForHash().entries(hgetKey);
    }

    @Override
    public Object hmsetByKey(String hsetKey, String key) {

        return this.redisTemplate.opsForHash().get(hsetKey, key);
    }
}
