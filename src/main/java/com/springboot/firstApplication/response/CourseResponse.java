package com.springboot.firstApplication.response;


import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.enums.CourseName;
import lombok.*;


import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private int id;

    private CourseName courseName;

    private BigDecimal fee;

    private List<Student> student;

    private Faculty faculty;

    public CourseResponse(Course course){
        this.id=course.getId();
        this.courseName=course.getCourseName();
        this.fee=course.getFee();
        this.student=course.getStudent();
        this.faculty= course.getFaculty();
    }

}
