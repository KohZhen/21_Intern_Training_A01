package com.puzzle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.puzzle.mapper")
public class ApplyJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplyJobApplication.class, args);
    }

}
