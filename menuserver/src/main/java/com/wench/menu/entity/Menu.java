package com.wench.menu.entity;

import lombok.Data;

/**
 * @Author: wench
 * @Description:
 * @Date: create in 2020/12/27 10:45
 */
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;
    private String author;
}
