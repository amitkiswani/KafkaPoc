package com.example;

import java.nio.charset.StandardCharsets;

public class Approval {
    private String data;

    public Approval(String data) {
        this.data = data;
    }

    public byte[] toBytes() {
        return data.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        return data;
    }
}

