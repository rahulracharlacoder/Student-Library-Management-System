package com.lms.Library_Management_System.converter;

import com.lms.Library_Management_System.dto.TransactionDTO;
import com.lms.Library_Management_System.model.Transaction;

public class TransactionConverter {

    public static Transaction TransactionDTOIntoTransaction(TransactionDTO transactionDTO) {

        Transaction transaction = Transaction.builder().
                transactionStatus(transactionDTO.getTransactionStatus()).
                fine(transactionDTO.getFine()).
                issuedOrReturn(transactionDTO.isIssuedOrReturn()).
                dueDate(transactionDTO.getDueDate()).
                build();

        return transaction;
    }
}
