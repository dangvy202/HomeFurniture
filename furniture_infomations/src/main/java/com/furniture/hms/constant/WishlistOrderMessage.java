package com.furniture.hms.constant;

import org.springframework.stereotype.Component;

@Component
public class WishlistOrderMessage {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String NOT_FOUND = "ACCOUNT_NOT_EXIST";
    public static final String EMPTY = "WISHLIST_IS_EMPTY";
}
