package com.springboot.firstApplication.controller;

import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.response.StudentResponse;
import com.springboot.firstApplication.service.student.StudentService;
import com.springboot.firstApplication.requests.student.StudentRequest;
import com.springboot.firstApplication.requests.student.UpdateStudentRequest;
import com.springboot.firstApplication.service.student.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest studentRequest){
        Student students= studentService.create(studentRequest);
        StudentResponse studentResponse = new StudentResponse(students);
        return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
    }


    @GetMapping("/{roll_no}")
    public ResponseEntity<StudentResponse> getById(@PathVariable("roll_no") int studentRoll) {
        Student student= studentService.getStudentById(studentRoll);
        StudentResponse studentResponse = new StudentResponse(student);
        return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> search(@RequestParam(value = "dob",required = false) LocalDate dob, @RequestParam(value = "name",required = false) String name ){
         List<Student> student= studentService.search(dob,name);
         List<StudentResponse> studentResponse = student.stream()
                 .map(StudentResponse::new )
                 .toList();
        return new ResponseEntity<List<StudentResponse>>(studentResponse, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<StudentResponse> update(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.update(updateStudentRequest);
        StudentResponse studentResponse = new StudentResponse(student);
        return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
    }

}
