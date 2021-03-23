package org.koszalka.cassandra.bureau.facade;

import org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity;
import org.koszalka.cassandra.bureau.persistence.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionsFacade {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsFacade(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public TransactionEntity getTransactions(String cpfNumber, String searchType, String value) {
        return transactionService.getTransactions(cpfNumber, searchType, value);
    }
}
