package com.lab.CodeFellowship.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppUserNotFoundException extends RuntimeException{

    public AppUserNotFoundException() {
    }

    public AppUserNotFoundException(String message) {
        super(message);
    }
}
