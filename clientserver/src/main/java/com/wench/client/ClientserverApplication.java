package com.wench.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/27 11:52
 */
@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
public class ClientserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientserverApplication.class, args);
    }
}
