package com.github.dto.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum LanguagesEnum {

    JAVA("java"),
    JAVA_SCRIPT("javascript"),
    PYTHON("python"),
    PHP("php"),
    ASSEMBLY("assembly"),
    GO("go"),
    C("c");

    @NonNull
    private final String name;
}
