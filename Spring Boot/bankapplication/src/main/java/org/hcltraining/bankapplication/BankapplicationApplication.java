package org.hcltraining.bankapplication;

import org.hcltraining.bankapplication.entity.Account;
import org.hcltraining.bankapplication.entity.Transcation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
