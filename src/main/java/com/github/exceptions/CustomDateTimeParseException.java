package com.github.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomDateTimeParseException extends RuntimeException {

    public CustomDateTimeParseException() {
        super("Invalid from date input value, should be yyyy-MM-dd");
        log.error("[CustomDateTimeParseException thrown] Invalid from date input value, should be 'yyyy-MM-dd'");
    }

    public CustomDateTimeParseException(String message) {
        super(message);
    }
}