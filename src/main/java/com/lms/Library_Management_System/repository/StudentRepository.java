package com.lms.Library_Management_System.repository;

import com.lms.Library_Management_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findBySem(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM student WHERE department= :Dept;")
    public List<Student> findByDepartment(String Dept);
}
