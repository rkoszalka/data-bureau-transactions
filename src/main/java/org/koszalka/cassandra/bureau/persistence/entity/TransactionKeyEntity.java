package org.koszalka.cassandra.bureau.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;
import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;


@Getter
@Setter
@PrimaryKeyClass
public class TransactionKeyEntity implements Serializable {

    @PrimaryKeyColumn(name = "CPF", type = PARTITIONED)
    private String cpf;

    @PrimaryKeyColumn(name = "NAM_PERSON", ordinal = 0)
    private String personName;

    @PrimaryKeyColumn(name = "person_id", ordinal = 1, ordering = DESCENDING)
    private UUID id;

    public TransactionKeyEntity(final String cpf, final String personName, final UUID id) {
        this.cpf = cpf;
        this.id = id;
        this.personName = personName;
    }

}