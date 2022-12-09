package com.prixbanque.application.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 * Modèle des clients
 */
@Document(collection="client")
public class Client {

	@Id
	private String id;

	private String firstname;
	private String lastname;
	private String mailadress;
	private String pwd;
	
	@DBRef
	private Set<Role> role;
	
	/**
	 * Constructeur par défaut
	 */
	public Client() {}
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param mailadress
	 *  Constructeur
	 * @param pwd 
	 */
	public Client(String firstname, String lastname, String mailadress, String pwd)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.mailadress = mailadress;
		this.pwd = pwd;
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
	 * @return le mdp
	 */
	public String getPwd() {
		return this.pwd;
	}

	/**
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return le role
	 */
	public Set<Role> getRole() {
		return this.role;
	}

	/**
	 * @param role
	 */
	public void setRole(Set<Role> role) {
		this.role = role;
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
