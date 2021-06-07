package org.yan.common;

public class CustomResponse {
    private Integer code;
    private String message;
    private Object data;

    private CustomResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static CustomResponse getInstance(Object data) {
        return null;
    }
}
