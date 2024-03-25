package com.furniture.hms.enums;

import lombok.Getter;

@Getter
public enum ImageEnum {
    NULL("NULL" , 2),
    FAIL_EXTENSION("FAIL_EXTENSION" , 0),
    SUCCESS("SUCCESS" , 1);

    private String value;
    private int key;

    ImageEnum(String value, int key) {
        this.key = key;
        this.value = value;
    }
}
