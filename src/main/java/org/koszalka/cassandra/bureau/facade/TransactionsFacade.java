package org.koszalka.cassandra.bureau.facade;

import org.koszalka.cassandra.bureau.persistence.schema.Transaction;
import org.koszalka.cassandra.bureau.persistence.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionsFacade {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsFacade(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Transaction getTransactions(String cpfNumber, String searchType, String value) {
        return transactionService.getTransactions(cpfNumber, searchType, value);
    }
}
