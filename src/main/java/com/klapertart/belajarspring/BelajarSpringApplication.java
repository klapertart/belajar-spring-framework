package com.klapertart.belajarspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

public class BelajarSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BelajarConfiguration.class, args);
	}

}
