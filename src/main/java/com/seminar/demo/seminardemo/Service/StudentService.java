package com.seminar.demo.seminardemo.Service;

import java.util.List;

import com.seminar.demo.seminardemo.Entity.Student;
import com.seminar.demo.seminardemo.Repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository repository) {
        this.studentRepository = repository;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findAllByMajor(major);
    }

    public void saveNewStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }
}
