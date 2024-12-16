package com.lms.Library_Management_System.service;

import com.lms.Library_Management_System.converter.AuthorConverter;
import com.lms.Library_Management_System.dto.AuthorDTO;
import com.lms.Library_Management_System.model.Author;
import com.lms.Library_Management_System.model.Book;
import com.lms.Library_Management_System.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addauthor(AuthorDTO authorDTO) {

        Author author = AuthorConverter.AuthorDTOIntoAuthor(authorDTO);
        authorRepository.save(author);

        return "Author saved sucessfully";
    }
}
