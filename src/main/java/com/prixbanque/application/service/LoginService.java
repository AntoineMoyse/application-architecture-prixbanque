package com.prixbanque.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Role;
import com.prixbanque.application.repository.ClientRepository;
import com.prixbanque.application.repository.RoleRepository;

/**
 * @author antoine
 * Classe service pour la connexion
 */
@Service
public class LoginService{

	@Autowired
	private ClientRepository clientrepo;
	
	@Autowired
	private RoleRepository rolerepo;
	
	/**
	 * @return je sais pas laisse moi tranquille
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	/**
	 * @param email
	 * @return client associé à l'adresse mail
	 */
	public Client findClientBymailadress(String email) {
	    return this.clientrepo.findClientBymailadress(email);
	}
	
	/**
	 * @param client
	 */
	public void newClient(Client client) {
	    client.setPwd(passwordEncoder().encode(client.getPwd()));
	    Role userRole = this.rolerepo.findByRole("ADMIN"); //$NON-NLS-1$
	    client.setRole(new HashSet<>(Arrays.asList(userRole)));
	    this.clientrepo.save(client);
	}
}
