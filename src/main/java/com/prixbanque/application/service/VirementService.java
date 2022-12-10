package com.prixbanque.application.service;

import com.prixbanque.application.controller.VirementController;
import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Solde;
import com.prixbanque.application.model.Virement;
import com.prixbanque.application.repository.SoldeRepository;
import com.prixbanque.application.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author antoine
 * Classe Service pour les virements
 */
@Service
public class VirementService {

    @Autowired
    private VirementRepository virementrepo;

    @Autowired
    private VirementController virementController;

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
        Solde soldepayeur = this.virementController.soldecontroller.soldeservice.findSoldeByClient(clientpayeur);
        soldepayeur.setMontant(soldepayeur.getMontant() - montant);
        Solde soldereceveur = this.virementController.soldecontroller.soldeservice.solderepo.findSoldeByClient(clientreceveur);
        soldereceveur.setMontant(soldereceveur.getMontant() + montant);
        this.virementController.soldecontroller.soldeservice.solderepo.save(soldepayeur);
        this.virementController.soldecontroller.soldeservice.solderepo.save(soldereceveur);
    }
}
