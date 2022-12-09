package com.prixbanque.application.service;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Solde;
import com.prixbanque.application.model.Virement;
import com.prixbanque.application.repository.SoldeRepository;
import com.prixbanque.application.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author antoine
 * Classe Service pour les virements
 */
@Service
public class VirementService {

    @Autowired
    private VirementRepository virementrepo;

    @Autowired
    private SoldeRepository solderepo;

    public Virement findVirementByClientPayeur(Client clientpayeur){
        return this.virementrepo.findVirementByClientPayeur(clientpayeur);
    }

    public Virement findVirementByClientReceveur(Client clientreceveur){
        return this.virementrepo.findVirementByClientReceveur(clientreceveur);
    }

    public void newVirement(Virement newvirement){
        this.virementrepo.save(newvirement);
        this.echange(newvirement.getMontant(), newvirement.getClientPayeur(), newvirement.getClientReceveur());
    }

    private void echange(float montant, Client clientpayeur, Client clientreceveur){
        Solde soldepayeur = this.solderepo.findSoldeByClient(clientpayeur);
        soldepayeur.setMontant(soldepayeur.getMontant() - montant);
        Solde soldereceveur = this.solderepo.findSoldeByClient(clientreceveur);
        soldereceveur.setMontant(soldereceveur.getMontant() + montant);
        this.solderepo.save(soldepayeur);
        this.solderepo.save(soldereceveur);
    }
}
