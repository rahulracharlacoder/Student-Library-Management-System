package com.lms.Library_Management_System.controller;

import com.lms.Library_Management_System.dto.TransactionDTO;
import com.lms.Library_Management_System.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionDTO transactionDTO) {

        String response = transactionService.addTransaction(transactionDTO);
        return response;

    }
}
