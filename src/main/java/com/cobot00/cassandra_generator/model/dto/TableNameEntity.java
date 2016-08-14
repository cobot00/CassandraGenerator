package com.cobot00.cassandra_generator.model.dto;

import lombok.Value;

@Value
public class TableNameEntity {

    private final String tableName;
    private final String javaClassName;
    private final String parentClassName;

}
