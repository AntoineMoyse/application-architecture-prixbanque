package com.prixbanque.application.repository.SoldeRepository;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Solde;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author antoine
 * Interface repository pour les soldes
 */
@Repository
public interface SoldeRepository extends MongoRepository<Solde, String> {

    Solde findSoldeByClient(Client client);
}
