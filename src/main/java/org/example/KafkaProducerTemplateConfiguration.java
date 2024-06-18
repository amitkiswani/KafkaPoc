package org.example;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerTemplateConfiguration {
    private static final String JAAS_CONFIG_PREFIX = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"";
    private static final String PASSWORD_FIELD = "\" password=\"";




    public KafkaTemplate<String, String> createSorEventKafkaTemplate( ProduceTopic sorEventTopic){
        return createKafkaTemplateFromTopic(sorEventTopic, String.class, String.class);
    }

    private <k, v> KafkaTemplate<k, v> createKafkaTemplateFromTopic(ProduceTopic produceTopic, Class<k> key, Class<v> value){
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, produceTopic.getBootstrapServers());
        producerProperties.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
        producerProperties.put(ProducerConfig.ACKS_CONFIG, produceTopic.getAcks());
        producerProperties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, produceTopic.getMaxInFlightRequestPerConnection());


        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, produceTopic.getKeySerializer());
            producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, produceTopic.getValueSerializer());


        // We don't want all the below for local Kafka connection
        if (produceTopic.getUsername() != null && produceTopic.getPassword() != null) {
            producerProperties.put(SaslConfigs.SASL_JAAS_CONFIG, JAAS_CONFIG_PREFIX + produceTopic.getUsername() + PASSWORD_FIELD + produceTopic.getPassword() + "\";");
        }
        if (produceTopic.getSecurityProtocol() != null) {
            producerProperties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, produceTopic.getSecurityProtocol());
        }
        if (produceTopic.getSaslMechanism() != null) {
            producerProperties.put(SaslConfigs.SASL_MECHANISM, produceTopic.getSaslMechanism());
        }

        DefaultKafkaProducerFactory<k, v> factory = new DefaultKafkaProducerFactory<>(producerProperties);
        return new KafkaTemplate<>(factory);
    }
}
