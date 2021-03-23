package org.koszalka.cassandra.bureau.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Cassandra Database Transactions Entity
 * @author rkoszalka
 */
@Getter
@Setter
@Table("RA_TRANSACTIONS")
public class TransactionEntity {

    @PrimaryKey
    private TransactionKeyEntity key;

    @Column("DAT_LAST_SEARCH")
    private LocalDateTime lastSearch;

    @Column
    private double transactionValue;

    public TransactionEntity(final TransactionKeyEntity key, final LocalDateTime lastSearch, final double transactionValue) {
        this.key = key;
        this.lastSearch = lastSearch;
        this.transactionValue = transactionValue;
    }

}