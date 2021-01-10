package com.wench.menu.controller;

import com.wench.menu.entity.Menu;
import com.wench.menu.entity.Type;
import com.wench.menu.repository.MenuRepositroy;
import com.wench.menu.repository.TypeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/26 13:24
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Value("${server.port}")
    private String port;

    @Autowired
    MenuRepositroy menuRepositroy;

    @Autowired
    TypeRepositroy typeRepositroy;

    @GetMapping("/index")
    public String index() {
        return "菜品端口号为：" + this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        index = (index - 1) * limit;
        return menuRepositroy.findAll(index, limit);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes() {
        return typeRepositroy.findAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuRepositroy.deleteById(id);
    }

    @PostMapping("/save")
    void save(@RequestBody Menu menu) {
        menuRepositroy.save(menu);
    }

    @GetMapping("/findById/{id}")
    Menu findById(@PathVariable("id") long id) {
        return menuRepositroy.findById(id);
    }

    @PostMapping("/update")
    void update(@RequestBody Menu menu) {
        menuRepositroy.update(menu);
    }
}
