package com.github.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomInvalidQueryException extends RuntimeException {

    public CustomInvalidQueryException() {
        super("Language or From fields must contain valid values");
        log.error("[CustomInvalidQueryException thrown] Language or From fields must contain valid values");
    }

    public CustomInvalidQueryException(String message) {
        super(message);
    }
}