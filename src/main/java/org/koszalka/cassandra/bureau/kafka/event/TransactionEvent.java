package org.koszalka.cassandra.bureau.kafka.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TransactionEvent {

    public String cpfNumber;
    public String searchType;
    public Float transactionValue;

}
