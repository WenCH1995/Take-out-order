package com.wench.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:16
 */
@SpringBootApplication
@MapperScan("com.wench.user.repository")
public class UserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
