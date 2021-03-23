package org.koszalka.cassandra.bureau.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table("RA_TRANSACTIONS")
public class TransactionEntity {

    @PrimaryKey
    private TransactionKeyEntity key;

    @Column("DAT_LAST_SEARCH")
    private String lastSearch;

    @Column
    private double transactionValue;

    public TransactionEntity(final TransactionKeyEntity key, final String lastSearch, final double transactionValue) {
        this.key = key;
        this.lastSearch = lastSearch;
        this.transactionValue = transactionValue;
    }

}