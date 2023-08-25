package com.springboot.firstApplication.repository;

import com.springboot.firstApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT * FROM Student s WHERE (s.dob = :dob OR :dob ='%s' ) AND (s.name = :name OR :name IS NULL)", nativeQuery = true)
    List<Student>  findByNameAndDob(String name, LocalDate dob);

}
