package com.cobot00.cassandra_generator.model.dto;

import lombok.Value;

@Value
public class KeyColumnEntity {

    private final String constraintName;
    private final String columnName;
    private final String constraintType;
}
