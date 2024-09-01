package com.base_backend_spring.util;

import java.time.LocalDateTime;

public class Utils {

    public static LocalDateTime getNow() {
        return LocalDateTime.now();
    }

    public static String getNowStr() {
        return LocalDateTime.now().toString();
    }
}
