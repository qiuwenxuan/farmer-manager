package com.example.entity;

import java.io.Serializable;

//扶贫咨询表，继承Serializable标记接口表示该类可以被序列化（及可以转换成可存储或传输的形式）
public class Information implements Serializable {

    private Integer id;
    private String name;
    private String content;
    private String time;

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
}
