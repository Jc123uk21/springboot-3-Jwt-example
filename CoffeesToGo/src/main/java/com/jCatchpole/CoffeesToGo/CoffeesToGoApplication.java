package com.jCatchpole.CoffeesToGo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = "com.jcatchpole.CoffeesToGo")
public class CoffeesToGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeesToGoApplication.class, args);
	}

}
