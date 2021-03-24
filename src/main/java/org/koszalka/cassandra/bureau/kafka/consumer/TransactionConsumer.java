package org.koszalka.cassandra.bureau.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.cassandra.bureau.facade.TransactionsFacade;
import org.koszalka.cassandra.bureau.kafka.constants.EventsConstants;
import org.koszalka.cassandra.bureau.kafka.event.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TransactionConsumer {

    private final TransactionsFacade transactionsFacade;

    @Autowired
    public TransactionConsumer(TransactionsFacade transactionsFacade) {
        this.transactionsFacade = transactionsFacade;
    }

    @KafkaListener(topics = EventsConstants.TRANSACTION_TOPIC, containerFactory = EventsConstants.KAFKA_CONSUMER_FACTORY)
    public void routeActivitiesListener(TransactionEvent transactionEvent) {
        try {
            log.info("{}", transactionEvent);
            transactionsFacade.getTransactions(transactionEvent.getCpfNumber(), transactionEvent.getSearchType(),
                    transactionEvent.getTransactionValue().toString());
        } catch (IllegalArgumentException e) {
            log.error("Error while parsing. {}", e.getMessage());
        }
    }

}
