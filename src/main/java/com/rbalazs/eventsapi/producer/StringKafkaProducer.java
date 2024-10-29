package com.rbalazs.eventsapi.producer;

import com.rbalazs.eventsapi.enums.AppConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka Producer associated to the topic 'string-topic'.
 * This producer generates "string" type events/messages.
 *
 * @author Rodrigo Balazs
 */
@Service
public class StringKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringKafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(AppConstants.STRING_TOPIC, message);
    }
}