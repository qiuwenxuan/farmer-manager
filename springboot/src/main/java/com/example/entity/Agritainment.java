package com.example.entity;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/17 16:03
 * @Description 农家乐信息表
 */

public class Agritainment {
    private Integer id;
    private String name;
    private String content;
    private String time;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
