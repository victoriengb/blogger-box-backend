package com.dauphine.blogger_box_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Blogger Box backend",
		version = "1.0",
		description = "Blogger Box endpoints and api"
	)
)
public class BloggerBoxBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerBoxBackendApplication.class, args);
	}

}
