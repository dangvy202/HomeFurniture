package com.furniture.hms.enums;

public enum OrderStatusEnum {
    PAID("PAID"),
    UNPAID("UNPAID");

    private final String name;

    OrderStatusEnum(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
