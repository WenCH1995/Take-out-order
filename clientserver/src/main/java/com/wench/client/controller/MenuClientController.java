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
@RequestMapping("/menu")
public class MenuClientController {

    @Autowired
    MenuFeign menuFeign;

    /**
     * 分页查询列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return new MenuVO(0,"",1000, menuFeign.findAll(page, limit));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
        return "menu_manage";
    }

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", menuFeign.findTypes());
        modelAndView.setViewName("menu_add");
        return modelAndView;
    }

    /**
     * 添加
     * @param menu
     * @return
     */
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "menu_manage";
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuFeign.findById(id));
        modelAndView.addObject("list", menuFeign.findTypes());
        modelAndView.setViewName("menu_update");
        return modelAndView;
    }

    /**
     * 修改
     * @param menu
     * @return
     */
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "menu_manage";
    }
}
