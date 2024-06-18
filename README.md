# KafkaPoc
Implemented AWS MSK Kafka Client 

`./gradlew clean build`

To run this jar use command

    To publish `java -jar KafkaPoc-1.0.0.jar P`
    To Consume `java -jar KafkaPoc-1.0.0.jar C`



 # Summary
This code defines a reusable Kafka producer class that can send messages to a specified Kafka topic. It includes setting up Kafka producer properties, sending messages with metadata retrieval, and proper resource management. The publish method demonstrates how to configure and use this producer for sending Approval messages with security features enabled.

This code defines a Kafka producer example in Java that uses Apache Kafka to send messages to a specified topic.

# KafkaProducerExample
- The class KafkaProducerExample is defined as a generic class, meaning it can handle messages of any type specified when an instance is created.
- This static method sets up the properties required for the Kafka producer, creates an instance of KafkaProducerExample for Approval type messages, and sends a message:
- Kafka broker addresses and serialization classes are set in props.
- Security properties (SASL_SSL, SCRAM-SHA-512) and credentials are configured.
- The topic is specified.
- A KafkaProducerExample<Approval> instance is created.
- An Approval event is created and sent with a key (eventId).
- The producer is closed after sending the message.
- Custom Classes and Methods
- CustomSerializer: A custom serializer class (not provided in the snippet) that must implement the Kafka Serializer interface.
- Approval: A class representing the type of messages being sent (not provided in the snippet).

# KafkaConsumerExample
- The consumer enters an infinite loop to continuously poll for new messages.
- consumer.poll(Duration.ofMillis(100)): Polls for records with a timeout of 100 milliseconds.
- Iterates over each ConsumerRecord in the polled ConsumerRecords and prints the key, value, partition, and offset of each record.
- Finally, the consumer is closed to release resources.



