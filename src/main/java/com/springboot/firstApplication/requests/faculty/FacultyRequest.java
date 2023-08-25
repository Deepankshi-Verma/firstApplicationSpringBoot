package com.springboot.firstApplication.requests.faculty;

import com.springboot.firstApplication.enums.GenderEnum;
import com.springboot.firstApplication.validations.GenderValidator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FacultyRequest {

    @Pattern(regexp="(?:[A-Z][a-z]*)",message="please enter letters only")
    private String name;

    @GenderValidator(anyOf = {GenderEnum.F, GenderEnum.M})
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @NotNull
    @Min(value=50000 ,message = "Minimum  value for salary is 50000")
    @Max(value=1000000 ,message = "Maximum  value for salary is 1000000")
    private BigDecimal salary;

    private int courseId;
}
