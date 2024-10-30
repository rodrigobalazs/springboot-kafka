package com.rbalazs.eventsapi.controller;

import com.rbalazs.eventsapi.controller.swagger.EventsControllerSwagger;
import com.rbalazs.eventsapi.dto.ProductDTO;
import com.rbalazs.eventsapi.producer.ProductDTOKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Events REST Controller, used to trigger Events produced by {@link ProductDTOKafkaProducer}
 * API Documentation/Swagger at => http://<project_url>/swagger-ui/index.html
 *
 * @author Rodrigo Balazs
 */
@RestController
@RequestMapping("/events")
public class EventsController implements EventsControllerSwagger {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsController.class);

    private final ProductDTOKafkaProducer productDTOKafkaProducer;

    @Autowired
    public EventsController(final ProductDTOKafkaProducer productDTOKafkaProducer) {
        this.productDTOKafkaProducer = productDTOKafkaProducer;
    }

    @PostMapping("/sendProductDTO")
    public void sendProductDTO(@RequestBody ProductDTO productDTO) {
        productDTOKafkaProducer.send(productDTO);
    }
}

