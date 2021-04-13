package com.seminar.demo.seminardemo.Repository;

import java.util.List;

import com.seminar.demo.seminardemo.Entity.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    public List<Student> findAllByMajor(String major);
    
}

