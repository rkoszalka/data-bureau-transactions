package org.koszalka.cassandra.bureau.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koszalka.cassandra.bureau.TransactionsApplication;
import org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity;
import org.koszalka.cassandra.bureau.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TransactionsApplication.class)
@WebAppConfiguration
public class TransactionControllerTest {

    @MockBean
    private TransactionRepository transactionRepository;
    private final WebApplicationContext webApplicationContext;
    private org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity TransactionEntity;
    private MockMvc mvc;

    @Autowired
    public TransactionControllerTest(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @BeforeEach
    void beforeEach() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        when(transactionRepository.findByKeyCPFAndKeyTransactionValueGreaterThan(anyString(),  anyString()))
                .thenReturn((org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity) TransactionEntity);
        when(transactionRepository.findByKeyCPF(eq(anyString())))
                .thenReturn((org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity) TransactionEntity);
        when(transactionRepository.findByLastSearch(eq(LocalDateTime.now())))
                .thenReturn((org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity) TransactionEntity);
    }

    @Test()
    @DisplayName("Search for CPF Transactions | Just for examples purpose, not covering real test cases")
    void findByKeyCPFAndKeyTransactionValueGreaterThan() throws Exception {
        mvc.perform(get("/v1/transactions/{cpfNumber}/{searchType}/{value}", "36869262020", "1820"))
                .andExpect(status().isOk());
    }

    @Test()
    @DisplayName("Search for CPF Transactions | Just for examples purpose, not covering real test cases")
    void findByKeyCPF() throws Exception {
        mvc.perform(get("/v1/transactions/{cpfNumber}/{searchType}/{value}", "36869262020", "1820"))
                .andExpect(status().isOk());
    }

    @Test()
    @DisplayName("Search for CPF Transactions | Just for examples purpose, not covering real test cases")
    void findByLastSearch() throws Exception {
        mvc.perform(get("/v1/transactions/{cpfNumber}/{searchType}/{value}", LocalDateTime.now()))
                .andExpect(status().isOk());
    }

}
