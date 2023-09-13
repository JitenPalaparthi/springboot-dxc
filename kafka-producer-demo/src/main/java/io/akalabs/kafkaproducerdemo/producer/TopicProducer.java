package io.akalabs.kafkaproducerdemo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message){
        log.info("Producer payload: {}",message);
        kafkaTemplate.send(topicName,message);
    }
    
}
