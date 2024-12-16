package com.lms.Library_Management_System.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.lms.Library_Management_System.dto.StudentDTO;
import com.lms.Library_Management_System.model.Student;
import com.lms.Library_Management_System.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    Logger loggers = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO) {
        loggers.info("SaveStudent API entered");
        try {
            String response = studentService.addStudent(studentDTO);
            loggers.info("SaveStudent API ended");
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            loggers.error("Exception occurred"+e.getMessage());
            return ResponseEntity.internalServerError().body("Student could not be saved");
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByStudentId(@PathVariable int id) {
        try {
            Student student = studentService.acquireStudentById(id);
            return ResponseEntity.ok(student);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Student could not be saved");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> studentList = studentService.acquireAllStudents();
            return ResponseEntity.ok(studentList);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Students not found");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<String> countOfStudents() {
        try {
            Long count = studentService.numberOfStudents();
            return ResponseEntity.ok("Total number of students are " + count);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("No students to be count");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteByStudentId(@PathVariable int id) {
        try {
            String response = studentService.removeStudentById(id);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Student not deleted");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        try {
            String response = studentService.update(id, studentDTO);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Student not updated");
        }
    }

    @GetMapping("/getByPages")
    public ResponseEntity<?> getStudentsByPages(@RequestParam int pageNo,@RequestParam int pageSize) {
        try {
            List<Student> studentList = studentService.findStudentByPages(pageNo, pageSize);
            return ResponseEntity.ok(studentList);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("No pages to be displayed");
        }
    }

    @GetMapping("/getBySem")
    public  ResponseEntity<?> getStudentBySem(@RequestParam String Sem) {
        try {
            List<Student> lists = studentService.findStudentBySem(Sem);
            return ResponseEntity.ok(lists);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("No students to be displayed");
        }
    }

    @GetMapping("/getByDept")
    public  ResponseEntity<?> getStudentByDept(@RequestParam String Dept) {
        try {
            List<Student> lists = studentService.findStudentByDepartments(Dept);
            return ResponseEntity.ok(lists);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("No students to be displayed");
        }
    }
}
