package com.prixbanque.application;

import com.prixbanque.application.model.Solde;
import com.prixbanque.application.repository.ClientRepository;
import com.prixbanque.application.repository.SoldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prixbanque.application.model.Role;
import com.prixbanque.application.repository.RoleRepository;
import com.prixbanque.application.model.Client;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

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
	CommandLineRunner init(RoleRepository roleRepository, ClientRepository clientrepo, SoldeRepository solderepo) {

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

			Client client = clientrepo.findClientBymailadress("user.test@dum.com");
			if(client == null){
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				Client newclient = new Client();
				newclient.setPwd(bCryptPasswordEncoder.encode("password"));
				newclient.setRole(new HashSet<>(Arrays.asList(userRole)));
				newclient.setFirstname("User");
				newclient.setLastname("Test");
				newclient.setMailadress("user.test@dum.com");
				clientrepo.save(newclient);

				Solde newsolde = new Solde(50000.00f, newclient);
				solderepo.save(newsolde);
			}
	    };

	}
}