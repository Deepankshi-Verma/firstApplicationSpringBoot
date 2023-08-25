package com.springboot.firstApplication.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CourseNameValidator.class})
public @interface CourseNameConstraint {

    // error message
    String message() default "Invalid Course Name. Can be either CS,IT,ECE,EEE,ME,CE";
    //represents group of constraints

    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};

}
