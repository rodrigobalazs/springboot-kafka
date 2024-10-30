package com.rbalazs.eventsapi.controller.swagger;

import com.rbalazs.eventsapi.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * Swagger interface related to {@link EventsController}.
 * API Documentation/Swagger at => http://<project_url>/swagger-ui/index.html
 *
 * @author Rodrigo Balazs
 */
@Tag(name = "Events Kafka API", description = "API endpoints related to Kafka Events")
public interface EventsControllerSwagger {

    @Operation(summary = "Sends a new JSON/DTO Event via a Kafka Producer",
            description = "Sends a new JSON/DTO Event, this API call will trigger the execution of this particular Kafka Producer ProductDTOKafkaProducer.java")
    public void sendProductDTO(@RequestBody ProductDTO productDTO);
}