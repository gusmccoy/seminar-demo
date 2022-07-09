package com.seminar.demo.seminardemo.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

import racemanagement.trektrak.Entity.Student;
import racemanagement.trektrak.Repository.StudentRepository;
import racemanagement.trektrak.Service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student());
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> actual = studentService.getAllStudents();

        assertEquals(1, actual.size());
    }

    @Test
    public void getStudentsByMajor() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student());
        when(studentRepository.findAllByMajor("TESTMAJOR")).thenReturn(students);

        List<Student> actual = studentService.getStudentsByMajor("TESTMAJOR");

        assertEquals(1, actual.size());
    }

    @Test
    public void saveNewStudent() {
        Student newStudent = new Student(1, "First", "Last", "Major", 4.0);
        when(studentRepository.save(newStudent)).thenReturn(newStudent);

        studentService.saveNewStudent(newStudent);

        verify(studentRepository).save(any(Student.class));
    }
}
