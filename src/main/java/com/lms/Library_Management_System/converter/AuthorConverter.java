package com.lms.Library_Management_System.converter;


import com.lms.Library_Management_System.dto.AuthorDTO;
import com.lms.Library_Management_System.model.Author;

public class AuthorConverter {

    public static Author AuthorDTOIntoAuthor(AuthorDTO authorDTO) {

        Author author = Author.builder().
                name(authorDTO.getName()).
                gender(authorDTO.getGender()).
                country(authorDTO.getCountry()).
                rating(authorDTO.getRating()).
                build();

        return author;
    }
}
