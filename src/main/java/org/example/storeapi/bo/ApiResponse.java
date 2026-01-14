package org.example.storeapi.bo;

public class ApiResponse<T> {
    public String code;
    public String message;
    public T data;
    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}