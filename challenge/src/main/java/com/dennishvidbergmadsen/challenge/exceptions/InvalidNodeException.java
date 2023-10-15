package com.dennishvidbergmadsen.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNodeException extends BaseException {
    public InvalidNodeException(String cause) {
        super("E_INVALID_NODE", "The node operation violates node contraints(" + cause + ")");
    }
}
