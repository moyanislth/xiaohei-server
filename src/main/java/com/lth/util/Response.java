package com.lth.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int code;
    private String message;
    private T data;


    public Response<Object> fail() {
        return new Response<>(-1, "请求失败", null);
    }

    public Response<Object> fail(T data) {
        return new Response<>(-1, "请求失败", data);
    }

    public Response<Object> success() {
        return new Response<>(200, "请求成功", null);
    }

    public Response<Object> success(T data) {
        return new Response<>(200, "请求成功", data);
    }
}
