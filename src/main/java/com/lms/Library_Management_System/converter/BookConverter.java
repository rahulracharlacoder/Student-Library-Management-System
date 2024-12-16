package com.lms.Library_Management_System.converter;

import com.lms.Library_Management_System.dto.BookDTO;
import com.lms.Library_Management_System.model.Book;

public class BookConverter {

    public static Book BookDTOIntoBook(BookDTO bookDTO) {

        Book book = Book.builder().
                name(bookDTO.getName()).
                pages(bookDTO.getPages()).
                publisherName(bookDTO.getPublisherName()).
                genre(bookDTO.getGenre()).
                available(bookDTO.isAvailable()).
                build();

        return book;
    }
}
