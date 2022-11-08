package com.concretepage.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.concretepage.*")
@EntityScan("com.concretepage.*")
public class DemoredisApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoredisApplication.class, args);
	}

}