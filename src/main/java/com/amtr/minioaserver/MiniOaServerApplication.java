package com.amtr.minioaserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniOaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniOaServerApplication.class, args);
        System.out.println("Link Start!!!");
    }

}
