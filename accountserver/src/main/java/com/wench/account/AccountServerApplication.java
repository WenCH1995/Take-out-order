package com.wench.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:30
 */
@SpringBootApplication
@MapperScan("com.wench.account.repository")
public class AccountServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServerApplication.class, args);
    }
}
