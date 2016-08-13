package com.cobot00.cassandra_generator.model.dto;

import lombok.Data;

@Data
public class ColumnEntity {

    private String columnName;
    private String dataType;
    private String columnDefault = "";
    private boolean isNullable = false;
    private int characterMaximumLength;
    private int numericPrecision;
    private int numericScale;

}
