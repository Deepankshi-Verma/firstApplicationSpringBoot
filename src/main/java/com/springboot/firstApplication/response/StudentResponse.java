package com.springboot.firstApplication.response;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.enums.GenderEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter// used for lombok, generating the getter and setters.
@AllArgsConstructor
@Builder
public class StudentResponse {
    private int rollNo;
    private String name;
    private LocalDate dob;
    private GenderEnum gender;
    private String address;
    private Course course;


    public StudentResponse(Student student){
        this.rollNo=student.getRollNo();
        this.name=student.getName();
        this.dob=student.getDob();
        this.gender=student.getGender();
        this.address=student.getAddress();
        this.course= student.getCourse();
    }

}
