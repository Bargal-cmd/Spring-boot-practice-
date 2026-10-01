package com.pratice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppRunnner implements CommandLineRunner {
	 private String message;
	  private String environment;
	
	  private String database;
	   private boolean debug;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("default :"+message);
		 System.out.println("Environment : " + environment);
	        System.out.println("Database    : " + database);
	        System.out.println("Debug       : " + debug);
		
	}

}
// pass this args from commandline ->Run config-> Argument 

 //--spring.profiles.active=dev