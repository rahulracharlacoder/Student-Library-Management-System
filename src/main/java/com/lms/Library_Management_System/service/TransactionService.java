package com.lms.Library_Management_System.service;

import com.lms.Library_Management_System.converter.TransactionConverter;
import com.lms.Library_Management_System.dto.TransactionDTO;
import com.lms.Library_Management_System.model.Book;
import com.lms.Library_Management_System.model.Card;
import com.lms.Library_Management_System.model.Transaction;
import com.lms.Library_Management_System.repository.BookRepository;
import com.lms.Library_Management_System.repository.CardRepository;
import com.lms.Library_Management_System.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    public String addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = TransactionConverter.TransactionDTOIntoTransaction(transactionDTO);

        //from book
        Book book = bookRepository.findById(transactionDTO.getBook_id()).get();
        transaction.setBook(book);

        //from card
        Card card = cardRepository.findById(transactionDTO.getCard_id()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);
        return "Transaction saved successfully";
    }
}
