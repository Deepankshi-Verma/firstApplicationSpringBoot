package com.springboot.firstApplication.validations;

import com.springboot.firstApplication.enums.CourseName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.EnumSet;

public class CourseNameValidator implements ConstraintValidator<CourseNameConstraint,CourseName> {

    EnumSet<CourseName> set = EnumSet.allOf(CourseName.class);

    @Override
    public boolean isValid(CourseName courseName, ConstraintValidatorContext  cxt) {
        boolean result =set.contains(CourseName.valueOf(String.valueOf(courseName)));
         return result ;
   }
}