package com.github.utils;

import com.github.dto.repository.LanguagesEnum;
import com.github.exception.CustomDateTimeParseException;
import com.github.exception.CustomInvalidLanguageException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

@Slf4j
public class Validators {
    private final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Converts string to LocalDateTime, will throw CustomDateTimeParseException if failed
     * @param input
     * @return
     */
    public static String validateInputAsLocalDate(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return input != null ? LocalDate.parse(input, formatter).toString() : null;
        } catch (DateTimeParseException e) {
            log.error("Invalid from date input value, should be yyyy-MM-dd");
            throw new CustomDateTimeParseException();
        }
    }

    public static String validateInputAsLanguage(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return Arrays.stream(LanguagesEnum.values())
                .filter(enumLanguage -> enumLanguage.getName()
                        .equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(CustomInvalidLanguageException::new)
                .getName();
    }

}
