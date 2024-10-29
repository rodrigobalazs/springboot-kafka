package com.rbalazs.eventsapi.controller;

import com.rbalazs.eventsapi.producer.StringKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Events REST Controller, used to trigger Events produced by {@link StringKafkaProducer}
 * API Documentation/Swagger at => http://<project_url>/swagger-ui/index.html
 *
 * @author Rodrigo Balazs
 */
@RestController
@RequestMapping("/events")
public class EventsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsController.class);

    private final StringKafkaProducer stringKafkaProducer;

    @Autowired
    public EventsController(final StringKafkaProducer stringKafkaProducer) {
        this.stringKafkaProducer = stringKafkaProducer;
    }

    @PostMapping("/sendString")
    public void sendString(@RequestBody String message) {
        stringKafkaProducer.send(message);
    }
}

