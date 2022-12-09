package com.prixbanque.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 * Modèle des soldes
 */
@Document(collection="solde")
public class Solde {

	@Id
	private String id;
	
	private float montant;

	@DBRef
	private Client client;

	public Solde(float montant, Client client) {
		this.montant = montant;
		this.client = client;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
