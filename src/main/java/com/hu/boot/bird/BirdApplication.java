package com.hu.boot.bird;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(value = {"com.hu.boot.bird.aws.dao"},basePackages = "com.hu.boot.bird.nfcs.mapper")
@EnableWebMvc
public class BirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirdApplication.class, args);
    }

}
