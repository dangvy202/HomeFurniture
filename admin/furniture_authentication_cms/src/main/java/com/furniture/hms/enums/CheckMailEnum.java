package com.furniture.hms.enums;


public enum CheckMailEnum {
    VALID("VALID"),
    INVALID("INVALID");

    private final String name;

    CheckMailEnum(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
