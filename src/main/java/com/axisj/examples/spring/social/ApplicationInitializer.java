package com.axisj.examples.spring.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class ApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}
}
