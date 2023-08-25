package com.springboot.firstApplication.requests.course;

import com.springboot.firstApplication.enums.CourseName;
import com.springboot.firstApplication.validations.CourseNameConstraint;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CourseRequest {

   @CourseNameConstraint
    @Enumerated(EnumType.STRING)
    private CourseName courseName;


    @NotNull
    @Min(value=10000 ,message = "Minimum  value for fee is 10000")
    @Max(value=100000 ,message = "Maximum  value for fee is 100000")
    private BigDecimal fee;

}
