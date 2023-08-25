package com.springboot.firstApplication.service.course;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.requests.course.CourseRequest;
import com.springboot.firstApplication.requests.course.UpdateCourseRequest;


public interface CourseService {
    public Course create(CourseRequest courseRequest);

    public Course getCourseById(int courseId);

    public Course update(UpdateCourseRequest updateCourseRequest);

}
