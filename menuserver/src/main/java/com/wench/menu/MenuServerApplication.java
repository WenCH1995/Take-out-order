package com.wench.menu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:23
 */
@SpringBootApplication
@MapperScan("com.wench.menu.repository")
public class MenuServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuServerApplication.class, args);
    }
}
