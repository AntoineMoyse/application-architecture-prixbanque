//MultipleMongoConfig.java
package com.prixbanque.application.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongodbConfig {
    @Primary
    @Bean(name = "db1ClientProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.client")
    public MongoProperties getNewDb1Props() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "db2SoldeProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.solde")
    public MongoProperties getNewDb2Props() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "db3VirementProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.virement")
    public MongoProperties getNewDb3Props() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "db1ClientMongoTemplate")
    public MongoTemplate db1ClientMongoTemplate() throws Exception {
        return new MongoTemplate(newdb1MongoDatabaseFactory(getNewDb1Props()));
    }

    @Bean(name ="db2SoldeMongoTemplate")
    public MongoTemplate db2SoldeMongoTemplate() throws Exception {
        return new MongoTemplate(newdb2MongoDatabaseFactory(getNewDb2Props()));
    }

    @Bean(name ="db3VirementMongoTemplate")
    public MongoTemplate db3VirementMongoTemplate() throws Exception {
        return new MongoTemplate(newdb3MongoDatabaseFactory(getNewDb3Props()));
    }

    @Primary
    @Bean
    public MongoDatabaseFactory newdb1MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory newdb2MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory newdb3MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

}
