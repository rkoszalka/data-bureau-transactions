package org.koszalka.cassandra.bureau.persistence.schema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;
import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;

/**
 * Cassandra Database Transactions Key Entity
 * @author rkoszalka
 */
@Getter
@Setter
@PrimaryKeyClass
public class TransactionKey implements Serializable {

    @PrimaryKeyColumn(name = "CPF", type = PARTITIONED)
    private String CPF;

    @PrimaryKeyColumn(name = "TRANSACTION_VALUE", ordinal = 0)
    private String transactionValue;

    @PrimaryKeyColumn(name = "person_id", ordinal = 1, ordering = DESCENDING)
    private UUID id;

    public TransactionKey(final String CPF, final String transactionValue, final UUID id) {
        this.CPF = CPF;
        this.id = id;
        this.transactionValue = transactionValue;
    }

}