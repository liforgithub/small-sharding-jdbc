package com.lxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lxy.mapper")
@SpringBootApplication
public class SmallShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallShardingJdbcApplication.class, args);
    }

}
