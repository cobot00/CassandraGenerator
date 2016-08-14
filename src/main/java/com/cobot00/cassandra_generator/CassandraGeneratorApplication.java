package com.cobot00.cassandra_generator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cobot00.cassandra_generator.config.ResourceConfiguration;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLColumnDao;
import com.cobot00.cassandra_generator.model.dao.PostgreSQLKeyColumnDao;
import com.cobot00.cassandra_generator.model.dto.ColumnEntity;
import com.cobot00.cassandra_generator.model.dto.KeyColumnEntity;

@SpringBootApplication
public class CassandraGeneratorApplication {

    @Autowired
    private ResourceConfiguration config;

    @Autowired
    private PostgreSQLColumnDao columnDao;

    @Autowired
    private PostgreSQLKeyColumnDao keyColumnDao;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CassandraGeneratorApplication.class, args);
        CassandraGeneratorApplication app = context.getBean(CassandraGeneratorApplication.class);
        app.run();
    }

    // TODO remove because this code is test
    public void run() {
        System.out.println("pgUrl: " + config.getPgUrl());
        System.out.println("pgUser: " + config.getPgUser());
        System.out.println("pgPswd: " + config.getPgPswd());

        List<ColumnEntity> result = columnDao.select(Arrays.asList("data_types"));
        System.out.println("size: " + result.size());

        List<KeyColumnEntity> keyColumns = keyColumnDao.select(Arrays.asList("multi_keys"));
        System.out.println("size: " + keyColumns.size());
        keyColumns.stream().forEach(System.out::println);
    }
}
