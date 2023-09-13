package io.akalabs.kafkaproducerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.akalabs.kafkaproducerdemo.producer.TopicProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    @GetMapping("/send")
    public void send() {
        log.info("user hit send endpoint");
        topicProducer.send("Hello This is a demo message using producer");
    }
}
