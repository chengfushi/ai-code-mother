package com.chengfu.aicodemotherapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.chengfu.aicodemotherapi.mapper")
public class AiCodeMotherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeMotherApiApplication.class, args);
    }

}
