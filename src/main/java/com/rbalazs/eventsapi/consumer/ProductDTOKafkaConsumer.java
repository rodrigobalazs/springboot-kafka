package com.rbalazs.eventsapi.consumer;

import com.rbalazs.eventsapi.dto.ProductDTO;
import com.rbalazs.eventsapi.enums.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer associated to the topic 'product-dto-topic'.
 *
 * @author Rodrigo Balazs
 */
@Service
public class ProductDTOKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductDTOKafkaConsumer.class);

    @KafkaListener(topics = AppConstants.PRODUCT_DTO_TOPIC)
    public void listen(ProductDTO productDTO) {
        LOGGER.info("received a JSON/ProductDTO event with this content => name:{} | available_quantity: {}" ,
                productDTO.getName(), productDTO.getAvailableQuantity());
    }
}