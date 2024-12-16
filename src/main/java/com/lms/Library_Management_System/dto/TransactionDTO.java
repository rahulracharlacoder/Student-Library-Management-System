package com.lms.Library_Management_System.dto;

import com.lms.Library_Management_System.enums.TransactionStatus;
import com.lms.Library_Management_System.model.Book;
import com.lms.Library_Management_System.model.Card;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class TransactionDTO {

    private TransactionStatus transactionStatus;

    private double fine;

    private boolean issuedOrReturn;

    private String dueDate;

    private int card_id;

    private int book_id;
}
