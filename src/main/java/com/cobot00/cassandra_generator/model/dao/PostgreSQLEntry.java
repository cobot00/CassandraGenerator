package com.cobot00.cassandra_generator.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cobot00.cassandra_generator.config.ResourceConfiguration;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PostgreSQLEntry implements DBEntry {

    @Autowired
    private final ResourceConfiguration resourceConfiguration;

    @Override
    public Connection getConnection() {
        Connection result = null;
        try {
            result = DriverManager.getConnection(
                    resourceConfiguration.getPgUrl(),
                    resourceConfiguration.getPgUser(),
                    resourceConfiguration.getPgPswd());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("DB ACCESS ERROR");
        }
        return result;
    }
}
