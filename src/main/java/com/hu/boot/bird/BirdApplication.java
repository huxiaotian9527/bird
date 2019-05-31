package com.hu.boot.bird;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.hu.boot.bird.dao")
@EnableWebMvc
public class BirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirdApplication.class, args);
    }

}
