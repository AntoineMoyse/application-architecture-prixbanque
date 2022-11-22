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
	
	/**
	 * @return 
	 * get firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @param firstname
	 * Set firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return
	 * get lastname
	 * 
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @param lastname
	 * set lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return
	 * get mailadress
	 */
	public String getMailadress() {
		return this.mailadress;
	}

	/**
	 * @param mailadress
	 * set mailadress
	 */
	public void setMailadress(String mailadress) {
		this.mailadress = mailadress;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString()
	{
		return String.format("Client[First name='%s', Last name ='%s', Mqil adress='%s']",this.firstname, this.lastname, this.mailadress); //$NON-NLS-1$
	}
}
