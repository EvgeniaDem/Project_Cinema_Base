package com.kata.cinema.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ScoreOutOfBoundException extends RuntimeException {

    public ScoreOutOfBoundException(String message) {
        super(message);
    }
}
