package com.ria.birdRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.ria.birdRegistry"  )
public class BirdRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdRegistryApplication.class, args);
	}

}
