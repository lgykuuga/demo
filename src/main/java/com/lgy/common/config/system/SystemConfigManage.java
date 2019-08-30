package com.lgy.common.config.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;

/**
 * 系统配置中心
 * 系统配置文件加载和处理,支持配置中心统心
 */
@SuppressWarnings("rawtypes")
public class SystemConfigManage {

    public static Logger logger = LoggerFactory.getLogger(SystemConfigManage.class);

    private static Map<String, String> systemConfigMap = Collections.synchronizedMap(new HashMap<String, String>(512));


    public static void initSystemConfigManage(Class obj) {

        SystemConfigManage.initSystemConfigManageFromFile(obj);

        logger.info("init serivce-->" + " zookeeper:" + SystemConfigManage.getProperty("zookeeper.status") + ",redis:"
                + SystemConfigManage.getProperty("system.redis") + ",saas:"
                + SystemConfigManage.getProperty("system.SAAS") + ",dataRoute:"
                + SystemConfigManage.getProperty("system.dataRoute") + ",rabbit:"
                + SystemConfigManage.getProperty("system.rabbitMQ") + ",jobs:"
                + SystemConfigManage.getProperty("system.jobs"));
    }

    /**
     * 从文件中加载系统配置
     */
    private static void initSystemConfigManageFromFile(Class obj) {
        initSystemConfig(obj);
        initLog4jConfig(obj);
        initRedisConfig(obj);

        initDatabaseConfig(obj);
        initXxlJobConfig(obj);
        initDubboConfig(obj);
        initRabbitConfig(obj);

        initFileServiceConfig(obj);
    }

    /**
     * 通过配置文件的key 或取配置文件value.例如:redis.ip
     *
     * @param key
     * @return value
     */
    public static String getProperty(String key) {

        return systemConfigMap.get(key);
    }

    /**
     * 通过配置文件的key 或取配置文件value.例如:redis.ip
     *
     * @param key
     * @return value
     */
    public static String getProperty(String key, String defaultValue) {

        if (systemConfigMap.get(key) == null) {
            return defaultValue;
        }
        return systemConfigMap.get(key);
    }

    /**
     * 此方法提供给 zookeeper 更新配置文件信息。
     *
     * @param key
     * @param value
     * @return value
     */
    public static String setSystemConfigFromZookeeper(String key, String value) {

        return systemConfigMap.put(key, value);
    }

    /**
     * 初始化zookeeper配置到内存MAP
     */
    public static void initZookeeperConfig(Class obj) {

        Properties prop = null;
        try {
            InputStream inputStream = obj.getClassLoader().getResourceAsStream("zookeeper.properties");
            InputStreamReader is = new InputStreamReader(inputStream, "UTF-8");

            prop = new Properties();
            prop.load(is); /// 加载属性列表
            is.close();
        } catch (Exception e) {
            logger.error(e.toString());
        }

        // prop 不为空，则配置了zookeper文件
        if (prop != null) {
            prop.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object k, Object v) {
                    systemConfigMap.put(k.toString(), v.toString());
                }
            });
        }
    }

    /**
     * 初始化redis配置到内存MAP
     */
    private static void initRedisConfig(Class obj) {
        Properties ps = getConfigProperties(obj,"META-INF/redis.properties");
        ps.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object k, Object v) {
                systemConfigMap.put(k.toString(), v.toString());
            }
        });
    }

    /**
     * 初始化redis配置到内存MAP
     */
    private static void initDubboConfig(Class obj) {
        Properties ps = getConfigProperties(obj,"dubbo.properties");
        ps.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object k, Object v) {
                systemConfigMap.put(k.toString(), v.toString());
            }
        });
    }

    /**
     * 初始化redis配置到内存MAP
     */
    private static void initLog4jConfig(Class obj) {
        Properties ps = getConfigProperties(obj,"log4j.properties");
        ps.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object k, Object v) {
                systemConfigMap.put(k.toString(), v.toString());
            }
        });
    }

    /**
     * 初始化system 配置到内存MAP
     */
    private static void initSystemConfig(Class obj) {
        Properties ps = getConfigProperties(obj,"META-INF/system.properties");
        ps.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object k, Object v) {
                systemConfigMap.put(k.toString(), v.toString());
            }
        });
    }

    /**
     * 初始化xxl-job 配置到内存MAP
     */
    private static void initXxlJobConfig(Class obj) {
        String jobs = systemConfigMap.get("system.jobs");
        if(jobs != null && jobs.equalsIgnoreCase("on")){
            Properties ps = getConfigProperties(obj,"META-INF/xxl-job.properties");
            ps.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object k, Object v) {
                    systemConfigMap.put(k.toString(), v.toString());
                }
            });

        }
    }

    /**
     * 初始化database配置到内存MAP
     */
    private static void initDatabaseConfig(Class obj) {
        String saas = systemConfigMap.get("system.SAAS");
        String dataRoute = systemConfigMap.get("system.dataRoute");
        if(dataRoute != null || saas != null){
            Properties ps = getConfigProperties(obj,"META-INF/database.properties");
            ps.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object k, Object v) {
                    systemConfigMap.put(k.toString(), v.toString());
                }
            });
        }
    }

    /**
     * 初始化kafka配置到内存MAP
     */
    private static void initRabbitConfig(Class obj) {
        String rabbit = systemConfigMap.get("system.rabbitMQ");
        if(rabbit != null && rabbit.equalsIgnoreCase("on")){
            Properties ps = getConfigProperties(obj,"META-INF/rabbitMQ.properties");
            ps.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object k, Object v) {
                    systemConfigMap.put(k.toString(), v.toString());
                }
            });
        }
    }
    /**
     * 初始化文件服务配置到内存MAP
     */
    private static void initFileServiceConfig(Class obj) {
        String fileservice = systemConfigMap.get("system.fileservice");
        if("on".equalsIgnoreCase(fileservice)){
            Properties ps = getConfigProperties(obj,"META-INF/fileservice.properties");
            ps.forEach(new BiConsumer<Object, Object>() {
                @Override
                public void accept(Object k, Object v) {
                    systemConfigMap.put(k.toString(), v.toString());
                }
            });
        }
    }
    /**
     * 读取配置文件
     *
     * @param fileName String
     * @return Properties
     */
    public static Properties getConfigProperties(Class obj, String fileName) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = obj.getClassLoader().getResourceAsStream(fileName);
            InputStreamReader is = new InputStreamReader(inputStream, "UTF-8");
            prop.load(is); /// 加载属性列表
            is.close();
            return prop;
        } catch (IOException e) {
            logger.error("读取配置文件异常:"+fileName, e);
        }

        return null;
    }


    public static void clearSystemConfigMap(){
        systemConfigMap.clear();
    }

}

