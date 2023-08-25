package com.springboot.firstApplication.controller;

import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.requests.faculty.FacultyRequest;
import com.springboot.firstApplication.requests.faculty.UpdateFacultyRequest;
import com.springboot.firstApplication.response.FacultyResponse;
import com.springboot.firstApplication.response.StudentFacResponse;
import com.springboot.firstApplication.response.StudentResponse;
import com.springboot.firstApplication.service.faculty.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<Faculty> create(@Valid @RequestBody FacultyRequest facultyRequest){
        Faculty faculty= facultyService.create(facultyRequest);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }

    @GetMapping("/{faculty_id}")
    public ResponseEntity<FacultyResponse> getById(@Valid @PathVariable("faculty_id") int facultyId){
        Faculty faculty= facultyService.getByFacultyId(facultyId);
        FacultyResponse facultyResponse= new FacultyResponse(faculty);
        return new ResponseEntity<FacultyResponse>(facultyResponse, HttpStatus.OK);
    }

    @GetMapping("/faculty/{faculty_id}")
    public ResponseEntity<List<StudentFacResponse>> searchStudentByFaculty(@PathVariable("faculty_id") int facultyId){
        List<StudentFacResponse> studentResponse= facultyService.searchStudentByFacultyId(facultyId).stream()
                .map(StudentFacResponse:: new).collect(Collectors.toList());
        return new ResponseEntity<List<StudentFacResponse>>(studentResponse, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Faculty> update(@Valid @RequestBody UpdateFacultyRequest updateFacultyRequest){
        Faculty faculty=  facultyService.update(updateFacultyRequest);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }

}
