package org.koszalka.cassandra.bureau.persistence.repository;

import org.koszalka.cassandra.bureau.persistence.schema.Transaction;
import org.koszalka.cassandra.bureau.persistence.schema.TransactionKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Cassandra Database Transactions Repository
 * @author rkoszalka
 */
@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, TransactionKey> {
    /**
     * @param CPF CPF Number
     * @return List of Transactions by CPF Key.
    */
    Transaction findByKeyCPF(final String CPF);

    /**
     * @param key_CPF CPF String
     * @param key_transactionValue String
     * @return List of Transactions by CPF key and value greater than transaction value
     */
    Transaction findByKeyCPFAndKeyTransactionValueGreaterThan(String key_CPF, String key_transactionValue);

    /**
     * @param lastSearch LocalDateTime
     * @return Transaction Entity by CPF key and value greater than transaction value
     */
    @Query(allowFiltering = true)
    Transaction findByLastSearch(final LocalDateTime lastSearch);
}