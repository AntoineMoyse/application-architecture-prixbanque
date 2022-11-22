package com.prixbanque.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.prixbanque.application.model.Client;

/**
 * @author antoine
 * Interface repository pour les clients
 */
@Repository
public interface ClientRepository extends MongoRepository<Client, String>{}
