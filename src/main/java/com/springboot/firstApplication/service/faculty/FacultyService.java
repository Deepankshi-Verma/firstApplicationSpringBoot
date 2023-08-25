package com.springboot.firstApplication.service.faculty;

import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.requests.faculty.FacultyRequest;
import com.springboot.firstApplication.requests.faculty.UpdateFacultyRequest;

import java.util.List;
import java.util.Objects;

public interface FacultyService {
    public Faculty create(FacultyRequest facultyRequest);

    public Faculty getByFacultyId(int facultyId);

    public List<Object[]>  searchStudentByFacultyId(int facultyId);

    public Faculty update(UpdateFacultyRequest updateFacultyRequest);

}
