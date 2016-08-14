package com.cobot00.cassandra_generator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CassandraDataType {

    INT("int"), STRING("String"), DOUBLE("double"), BIG_DECIMAL("BigDecimal"), LOCAL_DATE("LocalDate"), LOCAL_DATE_TIME(
            "LocalDateTime"), UUID("UUID"), BLOB("Blob");

    @Getter
    private final String type;

}
