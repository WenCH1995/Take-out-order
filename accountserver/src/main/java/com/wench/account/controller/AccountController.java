package com.wench.account.controller;

import com.wench.account.entity.Account;
import com.wench.account.repository.AdminRepository;
import com.wench.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:30
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Value("${server.port}")
    private String port;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/index")
    public String index() {
        return "账户服务端口号为： " + this.port;
    }

    /**
     * 登录接口
     * @param username
     * @param password
     * @param type
     * @return
     */
    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type) {
        Account account = new Account();
        switch (type) {
            case "user":
                account = userRepository.login(username, password);
                break;
            case "admin":
                account = adminRepository.login(username, password);
                break;
        }
        return account;
    }
}
