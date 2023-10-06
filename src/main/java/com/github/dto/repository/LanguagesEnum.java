package com.github.dto.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum LanguagesEnum {

    JAVA("java"),
    JAVA_SCRIPT("javascript"),
    PYTHON("python"),
    PHP("php"),
    C("c");

    @NonNull
    private final String name;

    public static LanguagesEnum getByString(String languageStr) {
        return Arrays.stream(values())
                .filter(enumLanguage -> enumLanguage.getName()
                        .equalsIgnoreCase(languageStr))
                .findFirst()
                .orElse(null);
    }
}
