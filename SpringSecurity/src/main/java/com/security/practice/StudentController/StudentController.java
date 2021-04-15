package com.security.practice.StudentController;

import com.security.practice.StudentEntity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENT_LIST= Arrays.asList(
            new Student(1,"Siddharth Bhandari"),
            new Student(2,"Anish Bhardwaj"),
            new Student(3,"Prayag Panta"),
            new Student(4,"Rajesh Jha")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId)throws Exception{
        return STUDENT_LIST.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student "+studentId+" does not exist"));
    }

}
