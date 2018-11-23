package com.shopping.dev.utils;

import java.sql.Timestamp;

public class GetTime {
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }
}
