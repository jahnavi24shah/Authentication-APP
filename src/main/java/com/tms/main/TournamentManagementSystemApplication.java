package com.tms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.tms")
@SpringBootApplication
public class TournamentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentManagementSystemApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TournamentManagementSystemApplication.class);
	}
	
}