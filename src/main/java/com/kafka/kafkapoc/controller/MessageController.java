package com.kafka.kafkapoc.controller;

import com.kafka.kafkapoc.kafka.JsonKafkaProducer;
import com.kafka.kafkapoc.kafka.KafkaProducer;
import com.kafka.kafkapoc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    // ..../publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish (@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to topic \nMessage -> " + message);
    }

    @GetMapping("/jsonpublish")
    public ResponseEntity<String> publish (@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
