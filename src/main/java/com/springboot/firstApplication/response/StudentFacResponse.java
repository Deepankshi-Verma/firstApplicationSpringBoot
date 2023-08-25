package com.springboot.firstApplication.response;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter// used for lombok, generating the getter and setters.
@AllArgsConstructor
@Builder
public class StudentFacResponse {
        private int rollNo;
        private String name;
        private LocalDate dob;
        private GenderEnum gender;
        private String address;
        private int courseId;

        public StudentFacResponse(Object[] object){
            this.rollNo= (int) Long.parseLong( String.valueOf(object[0]));
            this.name= String.valueOf(object[1]);
            this.dob= LocalDate.parse(String.valueOf(object[2]));
            this.gender= GenderEnum.valueOf(String.valueOf(object[3]));
            this.address= String.valueOf(object[4]);
            this.courseId= (int) Long.parseLong( String.valueOf(object[5]));
        }
}


