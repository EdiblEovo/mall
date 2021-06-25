package com.edible.mallweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.edible")
@MapperScan("com.edible.malldao")
public class MallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebApplication.class, args);
    }

}
