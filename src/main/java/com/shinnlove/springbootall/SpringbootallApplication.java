package com.shinnlove.springbootall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shinnlove.springbootall.dao.mapper")
public class SpringbootallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootallApplication.class, args);
    }
}
