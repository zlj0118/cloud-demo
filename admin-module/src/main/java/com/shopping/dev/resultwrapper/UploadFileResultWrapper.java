package com.shopping.dev.resultwrapper;

public class UploadFileResultWrapper {
    private int error;
    private String url;
    private String message;

    public static UploadFileResultWrapper success(String url) {
        return new UploadFileResultWrapper(0, url, null);
    }

    public static UploadFileResultWrapper error() {
        return new UploadFileResultWrapper(1, null, "上传失败123");
    }

    public UploadFileResultWrapper() {
    }

    public UploadFileResultWrapper(int error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
