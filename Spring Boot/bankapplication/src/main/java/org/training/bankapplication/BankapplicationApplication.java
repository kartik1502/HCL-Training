package org.training.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.entity.Transcation;

@SpringBootApplication
public class BankapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankapplicationApplication.class, args);
	}
	
	@Bean
	public Account Account() {
		return new Account();
	}
	
	@Bean
	public Transcation Transcation() {
		return new Transcation();
	}

}
