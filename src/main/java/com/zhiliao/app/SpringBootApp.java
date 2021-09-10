package com.zhiliao.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableTransactionManagement //在springboot中处理事务的，开启事务管理器
@MapperScan("com.zhiliao.app.dao") //在启动类中配置扫描映射dao包，架构启动就不会报错
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class,args);
    }
}
