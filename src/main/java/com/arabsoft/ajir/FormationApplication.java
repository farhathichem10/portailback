package com.arabsoft.ajir;

import java.time.LocalDate;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
		System.out.println("*********************************");
		System.out.println("Application run correctly");
		System.out.println("*********************************");
		


	}
	@PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+01:00"));
    }

}
