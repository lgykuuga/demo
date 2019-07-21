package com.lgy.demo.condition;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        System.out.println("系统版本:" + ctx.getEnvironment().getProperty("os.name"));
    }
}
