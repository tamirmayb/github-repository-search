package com.github.validator;

import com.github.dto.repository.LanguagesEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<ValidLanguage, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return LanguagesEnum.getByString(value) != null;
    }
}
