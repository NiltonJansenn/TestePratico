package com.stockquotemanager.inatel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.stockquotemanager.inatel"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EventoAppMain {

	public static void main(String[] args) {
		SpringApplication.run(EventoAppMain.class, args);
	}

}
