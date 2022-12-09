package com.prixbanque.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author antoine
 * Modèle des virements
 */
@Document(collection="virement")
public class Virement {

    @Id
    private String Id;
    private float montant;
    private Client ClientPayeur;
    private Client ClientReceveur;

    public Virement() {}

    public Virement(float montant, Client clientPayeur, Client clientReceveur) {
        this.montant = montant;
        ClientPayeur = clientPayeur;
        ClientReceveur = clientReceveur;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Client getClientPayeur() {
        return ClientPayeur;
    }

    public void setClientPayeur(Client clientPayeur) {
        ClientPayeur = clientPayeur;
    }

    public Client getClientReceveur() {
        return ClientReceveur;
    }

    public void setClientReceveur(Client clientReceveur) {
        ClientReceveur = clientReceveur;
    }
}
