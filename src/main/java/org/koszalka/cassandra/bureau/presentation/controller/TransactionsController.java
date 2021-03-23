package org.koszalka.cassandra.bureau.presentation.controller;


import lombok.extern.slf4j.Slf4j;
import org.koszalka.cassandra.bureau.facade.TransactionsFacade;
import org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity;
import org.koszalka.cassandra.bureau.presentation.api.TransactionsAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * CPF Transactions Controller
 * @author rkoszalka
 */
@Slf4j
@RestController
public class TransactionsController implements TransactionsAPI {

    private final TransactionsFacade transactionsFacade;

    @Autowired
    public TransactionsController(TransactionsFacade transactionsFacade) {
        this.transactionsFacade = transactionsFacade;
    }

    /**
     * @param cpfNumber CPF Number
     * @return creditScoreDTO.
     */
    @Override
    public ResponseEntity<TransactionEntity> getCPFTransactions(@RequestParam String cpfNumber
            , @RequestParam String searchType, @RequestParam String value) {
        if (!StringUtils.hasText(cpfNumber)) {
            log.error("M=getCPFCreditScore, message=CPF number is required");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            TransactionEntity response = transactionsFacade.getTransactions(cpfNumber, searchType, value);
            if (Objects.isNull(response)) {
                log.error("M=.getCPFCreditScore, message=Credit score not found for {}", cpfNumber);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<TransactionEntity>(response, HttpStatus.OK);
        } catch (InternalError e) {
            log.error("M=getCPFCreditScore, message=Internal Server Error. {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
