package com.example.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = "com.example.*")
public class Activemq1Application {

	public static void main(String[] args) {
		SpringApplication.run(Activemq1Application.class, args);
	}

}
