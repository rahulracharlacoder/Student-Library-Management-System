package com.lms.Library_Management_System.dto;

import com.lms.Library_Management_System.enums.Genre;
import com.lms.Library_Management_System.model.Author;
import com.lms.Library_Management_System.model.Card;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class BookDTO {

    private String name;

    private int pages;

    private String publisherName;

    private Genre genre;

    private boolean available;

    private int author_id;

    private int card_id;
}
