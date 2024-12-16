package com.lms.Library_Management_System.service;

import com.lms.Library_Management_System.converter.BookConverter;
import com.lms.Library_Management_System.dto.BookDTO;
import com.lms.Library_Management_System.model.Author;
import com.lms.Library_Management_System.model.Book;
import com.lms.Library_Management_System.model.Card;
import com.lms.Library_Management_System.repository.AuthorRepository;
import com.lms.Library_Management_System.repository.BookRepository;
import com.lms.Library_Management_System.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;
    public String addBook(BookDTO bookDTO) {
        Book book = BookConverter.BookDTOIntoBook(bookDTO);

        //from author
        Author author = authorRepository.findById(bookDTO.getAuthor_id()).get();
        book.setAuthor(author);

        //from card
        Card card = cardRepository.findById(bookDTO.getCard_id()).get();
        book.setCard(card);

        bookRepository.save(book);
        return "Book saved successfully";
    }
}
