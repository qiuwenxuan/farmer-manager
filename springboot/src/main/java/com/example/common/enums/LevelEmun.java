package com.example.common.enums;

public enum LevelEmun {
    ORDINARY("普通户"),
    POOR("贫困户"),
    ;
    public String level;

    LevelEmun(String level) {
        this.level = level;
    }
}
