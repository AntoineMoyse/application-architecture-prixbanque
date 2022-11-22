package com.prixbanque.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
	@Query("{name:'?0'}")
    Client findClientbymailadress(String mailadress);
}
