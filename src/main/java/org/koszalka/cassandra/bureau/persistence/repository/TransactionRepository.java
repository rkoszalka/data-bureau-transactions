package org.koszalka.cassandra.bureau.persistence.repository;

import org.koszalka.cassandra.bureau.persistence.entity.TransactionEntity;
import org.koszalka.cassandra.bureau.persistence.entity.TransactionKeyEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Cassandra Database Transactions Repository
 * @author rkoszalka
 */
@Repository
public interface TransactionRepository extends CassandraRepository<TransactionEntity, TransactionKeyEntity> {
    /**
     * @param CPF CPF Number
     * @return List of Transactions by CPF Key.
    */
    List<TransactionEntity> findByKeyCPF(final String CPF);

    /**
     * @param key_CPF CPF String
     * @param key_transactionValue String
     * @return List of Transactions by CPF key and value greater than transaction value
     */
    List<TransactionEntity> findByKeyCPFAndKeyTransactionValueGreaterThan(String key_CPF, String key_transactionValue);

    /**
     * @param lastSearch LocalDateTime
     * @return List of Transactions by CPF key and value greater than transaction value
     */
    @Query(allowFiltering = true)
    List<TransactionEntity> findByLastSearch(final LocalDateTime lastSearch);
}