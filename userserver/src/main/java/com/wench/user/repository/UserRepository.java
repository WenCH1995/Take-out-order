package com.wench.user.repository;


import com.wench.user.entity.User;

import java.util.List;

public interface UserRepository {

    public List<User> findAll(int index, int limit);

    public int count();

    public void save(User user);

    public void deleteById(long id);

    User findById(long id);

    void update(User user);
}
