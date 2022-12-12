package com.prixbanque.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.prixbanque.application.repository.VirementRepository"},
        mongoTemplateRef = db3Virement.MONGO_TEMPLATE)
public class db3Virement {
    protected static final String MONGO_TEMPLATE = "db3VirementMongoTemplate";
}
