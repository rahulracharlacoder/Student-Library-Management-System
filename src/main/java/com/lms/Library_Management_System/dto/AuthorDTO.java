package com.lms.Library_Management_System.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorDTO {

    private String name;

    private String gender;

    private String country;

    private double rating;

}
