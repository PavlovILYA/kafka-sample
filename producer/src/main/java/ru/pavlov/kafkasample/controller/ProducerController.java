package ru.pavlov.kafkasample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProducerController {
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public void sendOrder(String msgId, String msg){
        log.info("pre-send to Kafka: msgId = {}, msg = {}", msgId, msg);
        kafkaTemplate.send("ExperimentalTopic", msgId, msg);
        log.info("post-send to Kafka");
    }
}
