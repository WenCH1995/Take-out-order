package com.wench.account.repository;


import com.wench.account.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
