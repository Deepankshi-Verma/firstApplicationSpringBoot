package com.springboot.firstApplication.service.student;

import com.springboot.firstApplication.entity.Course;
import com.springboot.firstApplication.entity.Student;
import com.springboot.firstApplication.repository.CourseRepository;
import com.springboot.firstApplication.repository.StudentRepository;
import com.springboot.firstApplication.requests.student.StudentRequest;
import com.springboot.firstApplication.requests.student.UpdateStudentRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student create(StudentRequest studentRequest){
        Course course= courseRepository.findById(studentRequest.getCourseId()).orElseThrow(() -> new EntityNotFoundException("No course with specified  ID  present"));
        Student student =  Student.builder()
              .name(studentRequest.getName().toUpperCase())
              .dob(studentRequest.getDob())
              .gender(studentRequest.getGender())
              .address(studentRequest.getAddress())
              .course(course)
              .build();
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int studentRoll){
            return studentRepository.findById(studentRoll).orElseThrow(() -> new EntityNotFoundException("No student with specified roll no present"));
    }
    @Override
    public List<Student > search(LocalDate  dob, String name ){
        if(Objects.isNull(dob) && Objects.isNull(name)){
            return studentRepository.findAll();
        }
        if(Objects.nonNull(name)){
            name= name.toUpperCase();
        }
        return studentRepository.findByNameAndDob(name,dob);
    }

    @Override
    public Student update( UpdateStudentRequest updateStudentRequest){
       Student student =studentRepository.findById(updateStudentRequest.getRoll()).orElseThrow(()-> new EntityNotFoundException("No student found"));

        if (Objects.nonNull(updateStudentRequest.getName())) {
               student.setName(updateStudentRequest.getName());
       }
        if(Objects.nonNull(updateStudentRequest.getGender())){
            student.setGender(updateStudentRequest.getGender());
        }
        if(Objects.nonNull(updateStudentRequest.getAddress())){
            student.setAddress(updateStudentRequest.getAddress());
        }
        if(Objects.nonNull(updateStudentRequest.getCourseId())){
            Course course= courseRepository.findById(updateStudentRequest.getCourseId()).orElseThrow(()-> new EntityNotFoundException("No course with specified course ID present"));;
            student.setCourse(course);
        }

        return studentRepository.save(student);
    }

}
