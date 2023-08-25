package com.springboot.firstApplication.response;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResponse{
    private int facultyId;
    private String name;
    private GenderEnum gender;
    private BigDecimal salary;
    private Course course;

    public FacultyResponse(Faculty faculty){
        this.facultyId= faculty.getFacultyId();
        this.name= faculty.getName();
        this.gender=faculty.getGender();
        this.salary=faculty.getSalary();
        this.course=faculty.getCourse();
    }


}
