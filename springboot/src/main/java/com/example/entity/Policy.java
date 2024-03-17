package com.example.entity;

import java.io.Serializable;

/**
 * @Author Wenxuan.qiu
 * @Date 2024/3/16 18:05
 * @Description 扶贫政策表类
 */

public class Policy implements Serializable {
    private Integer id;
    private String name;
    private String content;
    private String time;

    // 点赞量
    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
