package com.springboot.firstApplication.repository;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
