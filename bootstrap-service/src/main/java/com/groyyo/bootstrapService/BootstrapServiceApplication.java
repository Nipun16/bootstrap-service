package com.groyyo.bootstrapService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.groyyo" })
public class BootstrapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapServiceApplication.class, args);
	}

}