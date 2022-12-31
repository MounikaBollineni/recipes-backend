package com.projects.recipesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.annotation.MultipartConfig;

@SpringBootApplication
@MultipartConfig
public class RecipesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesServiceApplication.class, args);
	}

}
