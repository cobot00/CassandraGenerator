package com.cobot00.cassandra_generator.model.logic;

import java.util.HashMap;
import java.util.Map;

import com.cobot00.cassandra_generator.model.CassandraFieldType;

public class PG2CassandraFieldMapper {

    private final Map<String, CassandraFieldType> mapping = new HashMap<String, CassandraFieldType>() {
        {
            // integer
            put("smallint", CassandraFieldType.INT);
            put("integer", CassandraFieldType.INT);
            put("bigint", CassandraFieldType.INT);
            put("int2", CassandraFieldType.INT);
            put("int4", CassandraFieldType.INT);
            put("int", CassandraFieldType.INT);
            put("int8", CassandraFieldType.INT);

            // float
            put("real", CassandraFieldType.DOUBLE);
            put("double precision", CassandraFieldType.DOUBLE);
            put("numeric", CassandraFieldType.BIG_DECIMAL);

            // string
            put("varchar", CassandraFieldType.STRING);
            put("character varying", CassandraFieldType.STRING);
            put("text", CassandraFieldType.STRING);

            // date & timestamp
            put("date", CassandraFieldType.LOCAL_DATE);
            put("timestamp with time zone", CassandraFieldType.LOCAL_DATE_TIME);
            put("timestamp without time zone", CassandraFieldType.LOCAL_DATE_TIME);
        }
    };

    public CassandraFieldType getTypeForJava(String pgType) {
        CassandraFieldType result = mapping.get(pgType);
        if (result == null) {
            throw new IllegalArgumentException("pgType: " + pgType);
        }

        return result;
    }
}
