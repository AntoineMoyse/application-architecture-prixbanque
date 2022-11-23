package com.prixbanque.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.prixbanque.application.controller.LogInController;

/**
 * @author antoine
 * Classe pour run l'application
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application{
	
	@Autowired
	LogInController logInController;

	/**
	 * @param args
	 * Main du programme
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}