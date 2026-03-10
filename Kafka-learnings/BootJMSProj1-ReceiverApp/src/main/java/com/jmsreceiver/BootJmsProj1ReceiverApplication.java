package com.jmsreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BootJmsProj1ReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj1ReceiverApplication.class, args);
	}

}
