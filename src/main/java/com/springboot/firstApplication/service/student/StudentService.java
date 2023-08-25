package com.springboot.firstApplication.service.student;

import java.time.LocalDate;
import java.util.*;

import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.requests.student.StudentRequest;
import com.springboot.firstApplication.requests.student.UpdateStudentRequest;

public interface StudentService {

    public Student create(StudentRequest studentRequest);

    public Student getStudentById(int studentRoll) ;

    public List<Student> search(LocalDate dob, String name);

    public Student update(UpdateStudentRequest updateStudentRequest);


}
