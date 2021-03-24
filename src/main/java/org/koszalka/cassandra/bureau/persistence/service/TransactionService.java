package org.koszalka.cassandra.bureau.persistence.service;

import org.koszalka.cassandra.bureau.persistence.schema.Transaction;
import org.koszalka.cassandra.bureau.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private static final String LAST_SEARCH = "lastSearch";
    private static final String CPF = "cpf";
;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction getTransactions(String cpfNumber, String searchType, String value) {
        if (searchType.equals(LAST_SEARCH)) {
            // Just for example purpose
            final LocalDateTime lastSearch = LocalDateTime.now();
            return transactionRepository.findByLastSearch(lastSearch);
        }

        if (searchType.equals(CPF)) {
            // Just for example purpose
            return transactionRepository.findByKeyCPF(cpfNumber);
        }

        // Just for example purpose
        return transactionRepository.findByKeyCPFAndKeyTransactionValueGreaterThan(cpfNumber, value);
    }
}
