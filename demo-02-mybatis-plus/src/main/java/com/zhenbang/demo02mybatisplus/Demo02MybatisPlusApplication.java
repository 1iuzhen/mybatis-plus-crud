package com.zhenbang.demo02mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.zhenbang.demo02mybatisplus.mapper")
@SpringBootApplication
public class Demo02MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo02MybatisPlusApplication.class, args);
    }

}
