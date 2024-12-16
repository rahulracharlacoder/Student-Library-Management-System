package com.lms.Library_Management_System.dto;

import com.lms.Library_Management_System.enums.CardStatus;
import com.lms.Library_Management_System.model.Student;
import lombok.Data;

@Data
public class CardDTO {

    private CardStatus cardStatus;

    private int student_id;
}
