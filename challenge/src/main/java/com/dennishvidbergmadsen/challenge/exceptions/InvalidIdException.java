package com.dennishvidbergmadsen.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIdException extends BaseException {
    public InvalidIdException(Class type, long id) {
        super("E_INVALID_ID", "Id " + id + " of type " + type.getName() + " does not exist");
    }
}
