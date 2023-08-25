package com.springboot.firstApplication.controller;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.response.CourseResponse;
import com.springboot.firstApplication.service.course.CourseService;
import com.springboot.firstApplication.requests.course.CourseRequest;
import com.springboot.firstApplication.requests.course.UpdateCourseRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody CourseRequest courseRequest){
        Course course = courseService.create(courseRequest);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse>getById(@Valid@PathVariable("id") int courseID) {
        Course course= courseService.getCourseById(courseID);
        CourseResponse courseResponse= new CourseResponse(course);
        return new ResponseEntity<CourseResponse>(courseResponse, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Course> update( @Valid@RequestBody UpdateCourseRequest updateCourseRequest){
        Course course = courseService.update(updateCourseRequest);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


}
