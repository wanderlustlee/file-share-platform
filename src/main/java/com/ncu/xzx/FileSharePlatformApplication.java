package com.ncu.xzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ncu.xzx.mapper")
public class FileSharePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileSharePlatformApplication.class, args);
    }

}
