package com.lms.Library_Management_System.converter;

import com.lms.Library_Management_System.dto.StudentDTO;
import com.lms.Library_Management_System.model.Student;

public class StudentConverter {

    public static Student StudentDTOIntoStudent(StudentDTO studentDTO) {

        Student student = Student.builder().
                name(studentDTO.getName()).
                dob(studentDTO.getDob()).
                gender(studentDTO.getGender()).
                email(studentDTO.getEmail()).
                department(studentDTO.getDepartment()).
                sem(studentDTO.getSem()).
                build();

        return student;
    }
}
