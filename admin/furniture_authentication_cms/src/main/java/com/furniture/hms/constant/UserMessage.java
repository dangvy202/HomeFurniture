package com.furniture.hms.constant;

import org.springframework.stereotype.Component;

@Component
public class UserMessage {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String NOT_FOUND = "ACCOUNT NOT EXIST";
    public static final String EMAIL_EXIST = "EMAIL EXIST";
    public static final String BAD_CREDENTIALES = "BAD_CREDENTIALES";
    public static final String ACCOUNT_BLOCK = "ACCOUNT_BLOCK";
    public static final String DENIED_ROLE = "DENIED_ROLE";
    public static final String EXPIRED_USER = "TIME_EXPIRED";
    public static final String NOT_FOUND_TOKEN = "NOT_FOUND_TOKEN";
}
