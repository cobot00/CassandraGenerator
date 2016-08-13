package com.cobot00.cassandra_generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfiguration {

    @Value("${PG_URL}")
    private String pgUrl;

    @Value("${PG_USER}")
    private String pgUser;

    @Value("${PG_PSWD}")
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
