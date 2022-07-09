package racemanagement.trektrak.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import racemanagement.trektrak.Entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    public List<Student> findAllByMajor(String major);
    
}

