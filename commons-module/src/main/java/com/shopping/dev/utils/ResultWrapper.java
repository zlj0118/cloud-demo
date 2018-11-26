package com.shopping.dev.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 JYQ  on  2018/11/9,9:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultWrapper {
    private boolean status;
    private int code;
    private String message;
    private Object data;

    public static ResultWrapper success(Object data) {
        return ResultWrapper.success(data);
    }

    public static ResultWrapper error(int code, String message) {
        return ResultWrapper.error(code, null);
    }
}
