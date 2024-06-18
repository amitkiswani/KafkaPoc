package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        ProduceTopic pt = new ProduceTopic();
        pt.setBootstrapServers("b-1.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-3.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-2.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096");
        pt.setKeySerializer(StringSerializer.class.getName());
        pt.setValueSerializer( StringSerializer.class.getName());
        pt.setAcks("all");
        pt.setTopicName("core-services.dataclean.sor-processing.uw2");
        pt.setPassword("fZ%AkETEC@K7WztO");
        pt.setUsername("core-services-clean-p1");

        KafkaProducerTemplateConfiguration k = new KafkaProducerTemplateConfiguration();
        KafkaTemplate<String, String> temp = k.createSorEventKafkaTemplate(pt);

       //ProducerRecord<String, T> record = new ProducerRecord<>(pt.getTopicName(), "eventI", new Approval());
        //temp.send(record);

    }
    public static void main1(String[] args) {

        System.out.println("Hello world!");

        // Kafka producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "b-1.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-3.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-2.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
       // ProducerConfig

        // Create the Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(props);

        // Kafka topic
        String topic = "core-services.dataclean.sor-processing.uw2";

        // Send messages
        for (int i = 0; i < 10; i++) {
            String key = "key-" + i;
            String value = "value-" + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.printf("Sent record(key=%s value=%s) meta(partition=%d, offset=%d)\n", key, value, metadata.partition(), metadata.offset());
                } else {
                    exception.printStackTrace();
                }
            });
        }

        // Close the producer
        producer.close();

    }
}