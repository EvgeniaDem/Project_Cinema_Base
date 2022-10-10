package com.kata.cinema.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ScoreRestrictionsException extends RuntimeException {
    public ScoreRestrictionsException(String message) {
        super(message);
    }
}
