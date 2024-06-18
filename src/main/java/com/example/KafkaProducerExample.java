package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerExample<T> {

    private final KafkaProducer<String, T> producer;
    private final String topic;

    public KafkaProducerExample(Properties props, String topic) {
        this.producer = new KafkaProducer<>(props);
        this.topic = topic;
        System.out.println(topic);
    }

    public void sendMessage(String key, T value) throws Exception {
        System.out.println("Sending message ......");
        ProducerRecord<String, T> record = new ProducerRecord<>(topic, key, value);
        Future<RecordMetadata> future = producer.send(record);
        RecordMetadata metadata = future.get();
        System.out.printf("Sent record(key=%s value=%s) meta(partition=%d, offset=%d)\n",
                record.key(), record.value(), metadata.partition(), metadata.offset());
    }

    public void close() {
        producer.close();
    }

    public static void publish() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "b-1.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-3.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096,b-2.dev-clean-p1.ik1zdz.c4.kafka.us-west-2.amazonaws.com:9096");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", CustomSerializer.class.getName());
        // Add authentication properties
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "SCRAM-SHA-512");
        props.put("sasl.jaas.config",
                "org.apache.kafka.common.security.scram.ScramLoginModule required " +
                        "username=\"core-services-clean-p1\" " +
                        "password=\"fZ%AkETEC@K7WztO\";");

        String topic = "core-services.dataclean.approvals.uw2";

        System.out.println("setting properties");
        // Create a producer instance for Approval type
        KafkaProducerExample<Approval> approvalProducer = new KafkaProducerExample<>(props, topic);
        Approval approvalEvent = new Approval("approvalData");

        try {
            approvalProducer.sendMessage("eventId", approvalEvent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            approvalProducer.close();
        }
    }
}

