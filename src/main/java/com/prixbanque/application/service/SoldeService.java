package com.prixbanque.application.service;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Solde;
import com.prixbanque.application.repository.SoldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author antoine
 * Classe service pour le Solde
 */
@Service
public class SoldeService {

    @Autowired
    private SoldeRepository solderepo;

    public Solde findSoldeByClient(Client client){
        return this.solderepo.findSoldeByClient(client);
    }

    public void newSolde(float montant, Client client){
        montant = 10000.0f;
        Solde newsolde = new Solde(montant, client);
        solderepo.save(newsolde);
    }
}
