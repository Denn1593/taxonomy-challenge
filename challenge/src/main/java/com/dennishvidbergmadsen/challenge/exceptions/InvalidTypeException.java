package com.dennishvidbergmadsen.challenge.exceptions;

public class InvalidTypeException extends BaseException{
    public InvalidTypeException(String name) {

        super("E_INVALID_TYPE", "Invalid type " + name);
    }
}
