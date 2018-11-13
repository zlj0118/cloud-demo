package com.shopping.dev.utils;

/**
 * @author:毕胜朋
 * @date:2018/11/8 15:06
 */

public class ResultWrapper {
    private boolean status;
    private int code;
    private String message;
    private Object data;

    public ResultWrapper() {
    }

    public ResultWrapper(boolean status, int code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultWrapper success(Object data) {
        return new ResultWrapper(true, 200, "ok", data);
    }

    public static ResultWrapper error(int code, String message) {
        return new ResultWrapper(false, code, message, null);
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
