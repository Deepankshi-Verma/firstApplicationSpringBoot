package com.springboot.firstApplication.requests.student;

import com.springboot.firstApplication.enums.GenderEnum;
import com.springboot.firstApplication.validations.GenderValidator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {
    @Pattern(regexp="(?:[A-Z][a-z]*)",message="please enter letters only")
    private String name;

    @NotNull
    private LocalDate dob;

    @GenderValidator(anyOf = {GenderEnum.F, GenderEnum.M})
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String address;

    @NotNull
    private int courseId;

}
