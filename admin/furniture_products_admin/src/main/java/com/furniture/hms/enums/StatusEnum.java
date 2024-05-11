package com.furniture.hms.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    INVALID("INVALID" , 0),
    VALID("VALID" , 1);

    private String value;
    private int key;

    StatusEnum(String value, int key) {
        this.key = key;
        this.value = value;
    }
}
