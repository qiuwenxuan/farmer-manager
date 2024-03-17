package com.example.entity;

import java.io.Serializable;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/16 18:05
 * @Description 商品信息类
 */

public class Goods implements Serializable {
    // 商品id
    private Integer id;
    // 商品名称
    private String name;
    // 商品价格
    private String price;
    // 商品数量
    private String num;
    // 商品销量
    private String sales;
    // 商品图片
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
