package com.gregbender.contacts.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.*;

@Configuration
public class MongoConfig {
        public @Bean
        MongoClient mongoClient() {
            // pass in mongo connection string as Java env variable
            // localhost embedded mongo: -DmongoConnectionString=mongodb://localhost:55394
            // AWS mongo instance: -DmongoConnectionString=mongoConnectionString=mongodb+srv://<username>:<password>@<host>/<dbname>?retryWrites=true&w=majority
            return MongoClients.create(System.getenv("mongoConnectionString"));
        }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "database");
    }
}
