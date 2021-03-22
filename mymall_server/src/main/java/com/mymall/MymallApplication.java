package com.mymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mymall.dao")
@SpringBootApplication
public class MymallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallApplication.class, args);
    }

}
