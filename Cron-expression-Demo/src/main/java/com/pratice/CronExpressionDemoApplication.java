package com.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CronExpressionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronExpressionDemoApplication.class, args);
	}

}
