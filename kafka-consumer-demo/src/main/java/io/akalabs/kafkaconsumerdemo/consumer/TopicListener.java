
package io.akalabs.kafkaconsumerdemo.consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafkaRetryTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener{

    @Value("${topic.name.consumer}")
    private String topicName;

   
    @KafkaListener(topics="${topic.name.consumer}",groupId ="group_id" )
    public void consume(ConsumerRecord<String,String> record){
        log.info("Offset:{}",record.offset());
        log.info("Topic:{}",topicName);
       // log.info("Key:{}",record.key());
       // log.info("Headers:{}",record.headers());
        log.info("Partition:{}",record.partition());
        log.info("Data:{}",record.value());
    }
}