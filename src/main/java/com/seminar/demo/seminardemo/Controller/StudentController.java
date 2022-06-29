package com.seminar.demo.seminardemo.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.seminar.demo.seminardemo.Entity.Student;
import com.seminar.demo.seminardemo.Service.StudentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "https://www.app.gusmccoy.dev"})
@RestController
public class StudentController {

    private StudentService studentService;

    List<Student> students = new ArrayList<Student>();

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/all")
	public List<Student> getAllStudents() {
        System.out.print("Retrieving All Exisiting Students...");
		return studentService.getAllStudents();
	}

    @PostMapping("/student/new")
    public void saveNewStudent(@RequestBody Student newStudent) {
        System.out.println("New/Updated Student Recieved: ID = " + newStudent.getId());
        System.out.println("New/Updated Student Recieved: First = " + newStudent.getFirstName());
        System.out.println("New/Updated Student Recieved: Last = " + newStudent.getLastName());
        System.out.println("New/Updated Student Recieved: Major = " + newStudent.getMajor());
        System.out.println("New/Updated Student Recieved: GPA = " + newStudent.getGpa());
        studentService.saveNewStudent(newStudent);
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        System.out.println("Deleting Student by ID: ID = " + id);
        studentService.deleteStudent(id);
    }

    @PutMapping("/student/update")
    public void updateStudent(@RequestBody Student updatedStudent) {
        System.out.println("Updated/New Student Recieved: ID = " + updatedStudent.getId());
        System.out.println("Updated/New Student Recieved: First = " + updatedStudent.getFirstName());
        System.out.println("Updated/New Student Recieved: Last = " + updatedStudent.getLastName());
        System.out.println("Updated/New Student Recieved: Major = " + updatedStudent.getMajor());
        System.out.println("Updated/New Student Recieved: GPA = " + updatedStudent.getGpa());
        studentService.updateStudent(updatedStudent);
    }

    @GetMapping("/populate")
    public String populateDBwithTestData() {
        System.out.println("Populating In-Memory Database with Test Students...");
        students.add(new Student(1, "Tony", "Stark", "Computer Science", 4.0));
        students.add(new Student(2, "Peter", "Parker", "Computer Engineering", 3.75));
        students.add(new Student(3, "Bruce", "Wayne", "Computer Science", 3.5));
        students.add(new Student(4, "Bruce", "Banner", "Physics", 3.5));
        students.add(new Student(5, "Thor", "Odinson", "Sports Science" , 1.5));
        students.add(new Student(6, "Clark", "Kent", "Computer Engineering", 3.0));
        students.add(new Student(7, "Clint", "Barton", "Physics", 2.5));
        students.add(new Student(8, "Lex", "Luther", "Computer Science", 3.75));

        students.forEach(student -> studentService.saveNewStudent(student));

        return "populated";
    }
}
