package com.cobot00.cassandra_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cobot00.cassandra_generator.service.PG2CassandraService;

@SpringBootApplication
public class CassandraGeneratorApplication {

    @Autowired
    private PG2CassandraService PG2CassandraService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CassandraGeneratorApplication.class, args);
        CassandraGeneratorApplication app = context.getBean(CassandraGeneratorApplication.class);
        app.run();
    }

    public void run() {
        PG2CassandraService.execute();
    }
}
