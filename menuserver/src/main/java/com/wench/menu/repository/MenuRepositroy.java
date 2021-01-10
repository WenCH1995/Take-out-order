package com.wench.menu.repository;

import com.wench.menu.entity.Menu;

import java.util.List;

public interface MenuRepositroy {

    List<Menu> findAll(int index, int limit);

    int count();

    Menu findById(long id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(long id);
}
