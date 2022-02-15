package com.example.simplewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = {"com.example.simplewebapp"})
@SpringBootApplication
public class SimplewebappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SimplewebappApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SimplewebappApplication.class);
	}
}
