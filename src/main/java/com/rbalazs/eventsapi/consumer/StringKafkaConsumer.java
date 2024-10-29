package com.rbalazs.eventsapi.consumer;

import com.rbalazs.eventsapi.enums.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer associated to the topic 'string-topic'
 *
 * @author Rodrigo Balazs
 */
@Service
public class StringKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaConsumer.class);

    @KafkaListener(topics = AppConstants.STRING_TOPIC)
    public void listen(String message) {
        LOGGER.info("received this String message:{}" , message);
    }
}