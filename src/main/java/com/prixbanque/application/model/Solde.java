package com.prixbanque.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 * Modèle des soldes
 */
@Document("solde")
public class Solde {

	@Id
	private String id;
	
	private float montant;
	private Client client;
}
