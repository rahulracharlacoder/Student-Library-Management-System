package com.lms.Library_Management_System.controller;

import com.lms.Library_Management_System.dto.AuthorDTO;
import com.lms.Library_Management_System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorDTO authorDTO) {

        String response = authorService.addauthor(authorDTO);
        return response;
    }
}
