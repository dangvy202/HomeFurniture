package com.furniture.hms.enums;

public enum UserEnum {
    VALID("VALID"), INVALID("INVALID");

    private final String name;

    UserEnum(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
