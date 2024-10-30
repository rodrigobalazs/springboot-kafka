package com.rbalazs.eventsapi.producer;

import com.rbalazs.eventsapi.dto.ProductDTO;
import com.rbalazs.eventsapi.enums.AppConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka Producer associated to the topic 'product-dto-topic'.
 * This producer generates JSON {@link ProductDTO} events.
 *
 * @author Rodrigo Balazs
 */
@Service
public class ProductDTOKafkaProducer {
    private final KafkaTemplate<String, ProductDTO> kafkaTemplate;

    public ProductDTOKafkaProducer(final KafkaTemplate<String, ProductDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(ProductDTO productDTO) {
        kafkaTemplate.send(AppConstants.PRODUCT_DTO_TOPIC, productDTO);
    }
}