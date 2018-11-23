package com.shopping.dev.resultwrapper;

public class MyResultWrapper<T> {
    private int status;
    private String massage;
    private T data;

    public MyResultWrapper(int status, String massage, T data) {
        this.status = status;
        this.massage = massage;
        this.data = data;
    }

    public static <T>MyResultWrapper success(T data) {
        return new MyResultWrapper(200, "成功", data);
    }

    public static <T>MyResultWrapper success() {
        return new MyResultWrapper(200, "成功", null);
    }

    public static <T>MyResultWrapper error() {
        return new MyResultWrapper(500, "失败", null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
