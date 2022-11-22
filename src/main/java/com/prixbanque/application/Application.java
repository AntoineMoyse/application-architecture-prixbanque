package com.prixbanque.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.repository.ClientRepository;

/**
 * @author antoine
 * Classe pour run l'application
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application{
	
	@Autowired
	static
	ClientRepository clientrepo;

	/**
	 * @param args
	 * Main du programme
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * @param name
	 * @return Page hello qui affiche une phrase différente en fonction de ce qu'on rentre dans l'url
	 */
	@GetMapping("/hello")
	public static String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s!", name); //$NON-NLS-1$
	}
	
	/**
	 * @return liste des clients
	 * 
	 */
	@GetMapping("/Clients")
	public static String Client()
	{
		clientrepo.deleteAll();

	    // save a couple of customers
	    clientrepo.save(new Client("Moi", "Moi", "Moi@Moi.Moi")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	    clientrepo.save(new Client("Test", "Test", "Test@Test.Test")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	    // fetch all customers
	    System.out.println("Customers found with findAll():"); //$NON-NLS-1$
	    System.out.println("-------------------------------"); //$NON-NLS-1$
	    String test = null;
	    for (Client customer : clientrepo.findAll()) {
	      test = String.format(customer.toString());
	    }
	    return test;
	}
}