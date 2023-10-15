package com.dennishvidbergmadsen.challenge.exceptions;

public class BaseException extends RuntimeException{
    private String code;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }
}
