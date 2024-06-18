package com.example;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomSerializer implements Serializer<Approval> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Approval data) {
        // Implement the serialization logic for Approval
        return data.toBytes();
    }

    @Override
    public void close() {
    }
}

