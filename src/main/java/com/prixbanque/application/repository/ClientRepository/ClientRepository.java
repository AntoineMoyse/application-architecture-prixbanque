package com.prixbanque.application.repository.ClientRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prixbanque.application.model.Client;

/**
 * @author antoine
 * Interface repository pour les clients
 */
@Repository
public interface ClientRepository extends MongoRepository<Client, String>{
	/**
	 * @param mailadress
	 * @return le client associé à l'adresse mail
	 */
    Client findClientBymailadress(String mailadress);
}
