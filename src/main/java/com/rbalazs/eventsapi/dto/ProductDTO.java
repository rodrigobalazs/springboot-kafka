package com.rbalazs.eventsapi.dto;

import lombok.Data;

/**
 * Product DTO, the Kafka Producer and Consumer exchanges JSON events mapped by this DTO.
 */
@Data
public class ProductDTO {
    private String name;
    private int availableQuantity;
}