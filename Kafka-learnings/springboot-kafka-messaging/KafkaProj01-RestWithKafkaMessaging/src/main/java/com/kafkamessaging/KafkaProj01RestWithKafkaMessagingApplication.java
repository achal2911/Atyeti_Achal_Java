package com.kafkamessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaProj01RestWithKafkaMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProj01RestWithKafkaMessagingApplication.class, args);
	}

}
