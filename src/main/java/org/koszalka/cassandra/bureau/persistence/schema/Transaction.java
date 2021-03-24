package org.koszalka.cassandra.bureau.persistence.schema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Cassandra Database Transactions Entity
 * @author rkoszalka
 */
@Getter
@Setter
@Table("RA_TRANSACTIONS")
public class Transaction {

    @PrimaryKey
    private TransactionKey key;

    @Column("DAT_LAST_SEARCH")
    private LocalDateTime lastSearch;

    @Column
    private double transactionValue;

    public Transaction(final TransactionKey key, final LocalDateTime lastSearch, final double transactionValue) {
        this.key = key;
        this.lastSearch = lastSearch;
        this.transactionValue = transactionValue;
    }

}