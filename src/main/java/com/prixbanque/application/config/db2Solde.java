package com.prixbanque.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.prixbanque.application.repository.SoldeRepository"},
        mongoTemplateRef = db2Solde.MONGO_TEMPLATE)
public class db2Solde {
    protected static final String MONGO_TEMPLATE = "db2SoldeMongoTemplate";
}
