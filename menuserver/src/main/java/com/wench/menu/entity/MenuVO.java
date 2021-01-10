package com.wench.menu.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/27 10:47
 */
@Data
public class MenuVO {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
