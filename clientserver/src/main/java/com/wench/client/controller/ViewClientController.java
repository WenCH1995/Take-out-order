package com.wench.client.controller;

import com.wench.client.entity.Menu;
import com.wench.client.entity.MenuVO;
import com.wench.client.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/27 12:06
 */
@Controller
@RequestMapping("/view")
public class ViewClientController {

    @Autowired
    MenuFeign menuFeign;

    /**
     * 重定向到某页面
     * @param index
     * @return
     */
    @GetMapping("/redirect/{index}")
    public String findAll(@PathVariable("index") String index){
        return index;
    }
}
