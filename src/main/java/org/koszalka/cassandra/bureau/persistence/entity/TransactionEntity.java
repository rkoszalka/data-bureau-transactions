package org.koszalka.cassandra.bureau.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
public class TransactionEntity {

    @PrimaryKey
    private final String id;
    private final String name;
    private final int age;

    public TransactionEntity(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{ @type = %1$s, id = %2$s, name = %3$s, age = %4$d }", getClass().getName(), getId(),
                getName(), getAge());
    }

}