package com.cobot00.cassandra_generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfiguration {

    @Value("${spring.datasource.url}")
    private String pgUrl;

    @Value("${spring.datasource.username}")
    private String pgUser;

    @Value("${spring.datasource.password}")
    private String pgPswd;

    public String getPgUrl() {
        return pgUrl;
    }

    public String getPgUser() {
        return pgUser;
    }

    public String getPgPswd() {
        return pgPswd;
    }
}
