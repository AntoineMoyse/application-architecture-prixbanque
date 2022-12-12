package com.prixbanque.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.prixbanque.application.repository.ClientRepository"},
        mongoTemplateRef = db1Client.MONGO_TEMPLATE)
public class db1Client {
    protected static final String MONGO_TEMPLATE = "db1ClientMongoTemplate";
}
