package com.prixbanque.application.repository.VirementRepository;

import com.prixbanque.application.model.Virement;
import com.prixbanque.application.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author antoine
 * Interface repository pour les virements
 */
@Repository
public interface VirementRepository extends MongoRepository<Virement, String> {

    Virement findVirementByClientPayeur(Client clientpayeur);
    Virement findVirementByClientReceveur(Client clientreceveur);
}
