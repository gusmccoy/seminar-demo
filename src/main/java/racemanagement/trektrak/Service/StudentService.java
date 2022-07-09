package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.Student;
import racemanagement.trektrak.Repository.StudentRepository;

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
