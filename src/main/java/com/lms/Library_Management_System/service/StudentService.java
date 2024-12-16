package com.lms.Library_Management_System.service;

import com.lms.Library_Management_System.converter.StudentConverter;
import com.lms.Library_Management_System.dto.StudentDTO;
import com.lms.Library_Management_System.enums.CardStatus;
import com.lms.Library_Management_System.model.Card;
import com.lms.Library_Management_System.model.Student;
import com.lms.Library_Management_System.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    Logger loggers = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentDTO studentDTO) {
        loggers.info("addStudent method started");
        Student student = StudentConverter.StudentDTOIntoStudent(studentDTO);
        if(student == null) {
            loggers.error("Exception occurred in addStudent method");
            throw new RuntimeException();
        }
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        loggers.info("addStudent method ended");
        return "Student and card saved successfully";
    }

    public Student acquireStudentById(int student_id) {
        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        if(!optionalStudent.isPresent()) throw new RuntimeException();
        Student student = optionalStudent.get();
        return student;
    }

    public List<Student> acquireAllStudents() {
        List<Student> list = studentRepository.findAll();
        if(list == null) throw new RuntimeException();
        return list;
    }

    public Long numberOfStudents() {
        Long number = studentRepository.count();
        if(number == null) throw new RuntimeException();
        return number;
    }

    public String removeStudentById(int student_id) {
        studentRepository.deleteById(student_id);
        return "Student deleted successfully";
    }

    public String update(int student_id, StudentDTO studentDTO) {
        Student student = acquireStudentById(student_id);
        if(student != null) {
            student.setName(studentDTO.getName());
            student.setDob(studentDTO.getDob());
            student.setGender(studentDTO.getGender());
            student.setEmail(studentDTO.getEmail());
            student.setDepartment(studentDTO.getDepartment());
            student.setSem(studentDTO.getSem());
            studentRepository.save(student);
            return "Student updated successfully";
        }
        else {
            return "Student Id not find";
        }
    }

    public List<Student> findStudentByPages(int pageNo, int pageSize){
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo, pageSize));
        List<Student> list = studentPage.getContent();
        return list;
    }

    public  List<Student> findStudentBySem(String Sem) {
        List<Student> list = studentRepository.findBySem(Sem);
        return list;
    }

    public  List<Student> findStudentByDepartments(String Dept) {
        List<Student> list = studentRepository.findByDepartment(Dept);
        return list;
    }
}
