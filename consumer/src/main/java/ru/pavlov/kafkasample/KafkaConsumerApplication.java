package ru.pavlov.kafkasample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@EnableKafka
@SpringBootApplication
public class KafkaConsumerApplication {

	@KafkaListener(topics="message")
	public void msgListener(String message){
		log.info("Message from ExperimentalTopic: {}", message);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
