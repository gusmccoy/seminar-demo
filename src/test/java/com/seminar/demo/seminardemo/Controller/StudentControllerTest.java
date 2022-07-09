package com.seminar.demo.seminardemo.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import racemanagement.trektrak.Controller.StudentController;
import racemanagement.trektrak.Entity.Student;
import racemanagement.trektrak.Service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student());
        when(studentService.getAllStudents()).thenReturn(students);

        List<Student> actual = studentController.getAllStudents();

        assertEquals(1, actual.size());
    }

    @Test
    public void saveNewStudent() {
        Student newStudent = 
            new Student(1, "First", "Last", "Major", 4.0);
        doNothing().when(studentService).saveNewStudent(newStudent);

        studentController.saveNewStudent(newStudent);

        verify(studentService).saveNewStudent(any(Student.class));
    }
    
}
