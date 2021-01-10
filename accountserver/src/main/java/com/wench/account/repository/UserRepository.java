package com.wench.account.repository;


import com.wench.account.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
