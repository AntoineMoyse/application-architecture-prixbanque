package com.prixbanque.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 * Modèle des clients
 */
@Document("client")
public class Client {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String mailadress;
	
	/**
	 * Constructeur par défaut
	 */
	public Client() {}
	
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param mailadress
	 *  Constructeur
	 */
	public Client(String firstname, String lastname, String mailadress)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.mailadress = mailadress;
	}
}
