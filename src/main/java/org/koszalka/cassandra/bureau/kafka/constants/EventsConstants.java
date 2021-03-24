package org.koszalka.cassandra.bureau.kafka.constants;

public class EventsConstants {
    public static final String TRANSACTION_TOPIC = "sys.dsr.bureau.transactions";
    public static final String KAFKA_CONSUMER_FACTORY = "kafkaJsonListenerContainerFactory";
    public static final String BOOTSTRAP_SERVER = "zookeeper.url";
    public static final String CONSUMER_GROUP_ID = "bureauTransactions";
}
