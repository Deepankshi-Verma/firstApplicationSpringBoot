package com.springboot.firstApplication.service.faculty;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Faculty;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.repository.CourseRepository;
import com.springboot.firstApplication.repository.FacultyRepository;
import com.springboot.firstApplication.requests.faculty.FacultyRequest;
import com.springboot.firstApplication.requests.faculty.UpdateFacultyRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Faculty create(FacultyRequest facultyRequest) {
        if(facultyRepository.findByCourseId(facultyRequest.getCourseId())==null) {
            Course course = courseRepository.findById(facultyRequest.getCourseId()).orElseThrow(() -> new EntityNotFoundException("No course with specified Id present"));
            Faculty faculty = Faculty.builder()
                    .name(facultyRequest.getName())
                    .gender(facultyRequest.getGender())
                    .salary(facultyRequest.getSalary())
                    .course(course)
                    .build();
            return facultyRepository.save(faculty);
        }else {
            throw new IllegalArgumentException("Only one Faculty can teach one course");
        }

    }

    @Override
    public Faculty getByFacultyId(int facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow(()->new EntityNotFoundException("No Faculty with specified Id present"));
    }

    @Override
    public List<Object[]> searchStudentByFacultyId(int facultyId) {
        return facultyRepository.findStudentByFacultyId(facultyId);
    }

    @Override
    public Faculty update(UpdateFacultyRequest updateFacultyRequest) {
        Faculty faculty= facultyRepository.findById(updateFacultyRequest.getFacultyId()).orElseThrow(()->new EntityNotFoundException("No Faculty with specified Id present"));

        if(Objects.nonNull(updateFacultyRequest.getName())){
            faculty.setName(updateFacultyRequest.getName());
        }
        if(Objects.nonNull(updateFacultyRequest.getSalary())){
            faculty.setSalary(updateFacultyRequest.getSalary());
        }
        if(Objects.nonNull(updateFacultyRequest.getGender())){
            faculty.setGender(updateFacultyRequest.getGender());
        }
        return facultyRepository.save(faculty);
    }
}
