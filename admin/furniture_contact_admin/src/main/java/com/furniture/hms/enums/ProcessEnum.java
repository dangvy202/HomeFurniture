package com.furniture.hms.enums;

public enum ProcessEnum {
    CREATE("CREATE"),
    PROCESSING("PROCESSING"),
    FINISHED("FINISHED"),
    FAIL("FAIL"),
    PENDING("PENDING");

    private String name;

    ProcessEnum(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
