package com.prixbanque.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prixbanque.application.model.Role;
import com.prixbanque.application.repository.RoleRepository;

/**
 * @author antoine
 * Classe pour run l'application
 */
@SpringBootApplication
public class Application{
	/**
	 * @param args
	 * Main du programme
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	static
	CommandLineRunner init(RoleRepository roleRepository) {

	    return args -> {

	        Role adminRole = roleRepository.findByRole("ADMIN"); //$NON-NLS-1$
	        if (adminRole == null) {
	            Role newAdminRole = new Role();
	            newAdminRole.setRole("ADMIN"); //$NON-NLS-1$
	            roleRepository.save(newAdminRole);
	        }

	        Role userRole = roleRepository.findByRole("USER"); //$NON-NLS-1$
	        if (userRole == null) {
	            Role newUserRole = new Role();
	            newUserRole.setRole("USER"); //$NON-NLS-1$
	            roleRepository.save(newUserRole);
	        }
	    };

	}
}