package com.prixbanque.application;

import com.prixbanque.application.model.Solde;
import com.prixbanque.application.model.Virement;
import com.prixbanque.application.repository.ClientRepository.ClientRepository;
import com.prixbanque.application.repository.SoldeRepository.SoldeRepository;
import com.prixbanque.application.repository.VirementRepository.VirementRepository;
import com.prixbanque.application.service.VirementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prixbanque.application.model.Role;
import com.prixbanque.application.repository.ClientRepository.RoleRepository;
import com.prixbanque.application.model.Client;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	CommandLineRunner init(RoleRepository roleRepository, ClientRepository clientrepo, SoldeRepository solderepo, VirementRepository virementrepo, VirementService virementservice) {

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

			Client client1 = clientrepo.findClientBymailadress("user.test@dum.com");
			Client client2 = clientrepo.findClientBymailadress("test.user@dum.com");
			if(client1 == null){
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				Client newclient1 = new Client();
				newclient1.setPwd(bCryptPasswordEncoder.encode("password"));
				newclient1.setRole(new HashSet<>(Arrays.asList(userRole)));
				newclient1.setFirstname("User");
				newclient1.setLastname("Test");
				newclient1.setMailadress("user.test@dum.com");
				clientrepo.save(newclient1);

				Solde newsolde1 = new Solde(50000.00f, newclient1);
				solderepo.save(newsolde1);
			}
			if(client2 == null){
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				Client newclient2 = new Client();
				newclient2.setPwd(bCryptPasswordEncoder.encode("password"));
				newclient2.setRole(new HashSet<>(Arrays.asList(userRole)));
				newclient2.setFirstname("Test");
				newclient2.setLastname("User");
				newclient2.setMailadress("test.user@dum.com");
				clientrepo.save(newclient2);

				Solde newsolde2 = new Solde(50000.00f, newclient2);
				solderepo.save(newsolde2);
			}

			maketest(client1, client2, virementrepo, virementservice);
	    };
	}

	public void maketest(Client client1, Client client2, VirementRepository virementrepo, VirementService virementservice){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		ArrayList<Virement> listevirement = new ArrayList<Virement>();

		listevirement = makelist(listevirement, client1, client2);

		LocalDateTime now = LocalDateTime.now();
		System.out.println("début test" + dtf.format(now));

		//makeaddingtest(listevirement, virementrepo);
		makeaddingtestservice(listevirement, virementservice);

		now = LocalDateTime.now();
		System.out.println("fin test" + dtf.format(now));
	}

	@Async
	public ArrayList<Virement> makelist(ArrayList<Virement> listevirement, Client client1, Client client2){
		for(int i = 0; i<2000; i++){
			Virement virement1 = new Virement(1000, client1, client2);
			Virement virement2 = new Virement(999, client2, client1);
			listevirement.add(virement1);
			listevirement.add(virement2);
		}
		return listevirement;
	}

	@Async
	public void makeaddingtest(ArrayList<Virement> listevirement, VirementRepository virementrepo){
		for(Virement virements : listevirement){
			virementrepo.save(virements);
		}
	}

	@Async
	public void makeaddingtestservice(ArrayList<Virement> listevirement, VirementService virementservice){
		for(Virement virements : listevirement){
			virementservice.newVirement(virements);
		}
	}
}