package org.hcltraining.mvcrud.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.hcltraining.mvcrud")
public class JpaConfig {

	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("kartik");
		return managerFactory;
	}

}
