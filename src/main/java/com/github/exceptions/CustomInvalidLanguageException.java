package com.github.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomInvalidLanguageException extends RuntimeException {

    public CustomInvalidLanguageException() {
        super("Invalid Language value");
        log.error("[CustomInvalidLanguageException thrown] Invalid Language value");
    }

    public CustomInvalidLanguageException(String message) {
        super(message);
    }
}