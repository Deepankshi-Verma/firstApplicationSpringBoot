package com.springboot.firstApplication.repository;

import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface  FacultyRepository extends JpaRepository<Faculty, Integer> {

    Faculty findByCourseId(int courseId);

    @Query(value = "SELECT * FROM student WHERE course_id=(SELECT course_id FROM faculty WHERE faculty_id =:facultyId);", nativeQuery = true)
    List<Object[]> findStudentByFacultyId(int facultyId);
}
