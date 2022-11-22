package com.prixbanque.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.repository.ClientRepository;

/**
 * @author antoine
 * Classe pour run l'application
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientrepo;

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
	 * @return
	 * Page hello qui affiche une phrase différente en fonction de ce qu'on rentre dans l'url
	 */
	@GetMapping("/hello")
	public static String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s!", name); //$NON-NLS-1$
	}

	@Override
	public void run(String... args) throws Exception {
		this.clientrepo.deleteAll();
		
		this.clientrepo.save(new Client("Moi", "Moi", "Moi@Moi.Moi")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.clientrepo.save(new Client("Test", "Test", "Test@Test.Test")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}