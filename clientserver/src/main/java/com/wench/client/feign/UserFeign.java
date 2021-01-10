package com.wench.client.feign;

import com.wench.client.entity.Menu;
import com.wench.client.entity.Type;
import com.wench.client.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/user/findTypes")
    List<Type> findTypes();

    @PostMapping("/user/save")
    void save(@RequestBody User user);

    @GetMapping("/user/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    @PostMapping("/user/update")
    void update(User user);
}
