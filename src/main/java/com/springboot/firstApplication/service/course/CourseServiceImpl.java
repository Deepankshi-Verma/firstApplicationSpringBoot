package com.springboot.firstApplication.service.course;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.repository.CourseRepository;
import com.springboot.firstApplication.requests.course.CourseRequest;
import com.springboot.firstApplication.requests.course.UpdateCourseRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    public Course create(CourseRequest courseRequest){
        Course course = Course.builder()
                .fee(courseRequest.getFee())
                .courseName(courseRequest.getCourseName())
                .build();
        return courseRepository.save(course);

    }

    public Course getCourseById(int courseId){
        return courseRepository.findById(courseId).orElseThrow(()-> new EntityNotFoundException("No course with specified course ID present"));
    }

    public Course update(UpdateCourseRequest updateCourseRequest){
        Course course= courseRepository.findById(updateCourseRequest.getId()).orElseThrow(()-> new EntityNotFoundException("No Course found"));

        if(Objects.nonNull(updateCourseRequest.getFee())){
            course.setFee(updateCourseRequest.getFee());
        }
        return courseRepository.save(course);
    }

}
