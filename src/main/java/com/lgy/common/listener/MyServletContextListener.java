package com.lgy.common.listener;

import com.lgy.common.rabbitMQ.InitRabbitMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    InitRabbitMQ initRabbitMQ;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("可以在系统启动时从数据库加载一些配置到redis或内存中");
        logger.info("ServletContext初始化");
        initRabbitMQ.createExchange();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("ServletContext销毁");
    }
}
