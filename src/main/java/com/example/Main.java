package com.example;

public class Main {

    public static void main(String[] args) {

        if(args[0].equals("P")){
            System.out.println("Publishing");
            KafkaProducerExample.publish();
        }else {
            System.out.println("Consuming");
            KafkaConsumerExample.consume();
        }
    }
}
