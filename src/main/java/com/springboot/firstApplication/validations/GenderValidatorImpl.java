package com.springboot.firstApplication.validations;

import com.springboot.firstApplication.enums.GenderEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GenderValidatorImpl implements ConstraintValidator<GenderValidator, GenderEnum> {
    private GenderEnum[] subset;

    @Override
    public void initialize(GenderValidator constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(GenderEnum value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}