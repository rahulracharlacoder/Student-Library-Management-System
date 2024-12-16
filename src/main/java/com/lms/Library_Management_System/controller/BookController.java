package com.lms.Library_Management_System.controller;

import com.lms.Library_Management_System.dto.BookDTO;
import com.lms.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookDTO bookDTO) {

        String response = bookService.addBook(bookDTO);
        return response;

    }
}
