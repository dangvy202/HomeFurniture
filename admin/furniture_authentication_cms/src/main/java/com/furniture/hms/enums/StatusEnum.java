package com.furniture.hms.enums;

public enum StatusEnum {
    VALID("VALID"),
    INVALID("INVALID");

    private final String name;

    StatusEnum(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
