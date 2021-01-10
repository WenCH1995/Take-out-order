package com.wench.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:00
 */
@SpringBootApplication
@MapperScan("com.wench.order.repository")
public class OrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class,args);
    }
}
