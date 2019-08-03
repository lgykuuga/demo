package com.lgy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableRabbit //开启RabbitMQ注解模式
@MapperScan("com.lgy.demo.mapper")//Mybatis plus扫描
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动成功" +
                " __       ____                \n" +
                "/\\ \\     /\\  _`\\              \n" +
                "\\ \\ \\    \\ \\ \\L\\_\\  __  __    \n" +
                " \\ \\ \\  __\\ \\ \\L_L /\\ \\/\\ \\   \n" +
                "  \\ \\ \\L\\ \\\\ \\ \\/, \\ \\ \\_\\ \\  \n" +
                "   \\ \\____/ \\ \\____/\\/`____ \\ \n" +
                "    \\/___/   \\/___/  `/___/> \\\n" +
                "                        /\\___/\n" +
                "                        \\/__/");
    }

}
