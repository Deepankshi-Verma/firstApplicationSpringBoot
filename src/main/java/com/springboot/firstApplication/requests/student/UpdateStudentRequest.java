package com.springboot.firstApplication.requests.student;

import com.springboot.firstApplication.enums.GenderEnum;
import com.springboot.firstApplication.validations.GenderValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class UpdateStudentRequest {
    @NotNull
    private int roll;

    @Pattern(regexp="(?:[A-Z][a-z]*)",message="please enter letters only")
    private String name ;

    @GenderValidator(anyOf = {GenderEnum.F, GenderEnum.M})
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String address;

    private Integer  courseId;
    // int mae default 0 hoti hai ... can not be null , Integer can be null isliye update mae issue aa rha tha

}
