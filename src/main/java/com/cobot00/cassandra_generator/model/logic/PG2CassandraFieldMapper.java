package com.cobot00.cassandra_generator.model.logic;

import java.util.HashMap;
import java.util.Map;

import com.cobot00.cassandra_generator.model.CassandraDataType;

public class PG2CassandraFieldMapper {

    private PG2CassandraFieldMapper() {
        // no instance
    }

    private static final Map<String, CassandraDataType> mapping = new HashMap<String, CassandraDataType>() {
        {
            // integer
            put("smallint", CassandraDataType.INT);
            put("integer", CassandraDataType.INT);
            put("bigint", CassandraDataType.INT);
            put("int2", CassandraDataType.INT);
            put("int4", CassandraDataType.INT);
            put("int", CassandraDataType.INT);
            put("int8", CassandraDataType.INT);

            // float
            put("real", CassandraDataType.DOUBLE);
            put("double precision", CassandraDataType.DOUBLE);
            put("numeric", CassandraDataType.BIG_DECIMAL);

            // string
            put("varchar", CassandraDataType.STRING);
            put("character varying", CassandraDataType.STRING);
            put("text", CassandraDataType.STRING);

            // date & timestamp
            put("date", CassandraDataType.LOCAL_DATE);
            put("timestamp with time zone", CassandraDataType.LOCAL_DATE_TIME);
            put("timestamp without time zone", CassandraDataType.LOCAL_DATE_TIME);
        }
    };

    public static CassandraDataType getTypeForJava(String pgType) {
        CassandraDataType result = mapping.get(pgType);
        if (result == null) {
            throw new IllegalArgumentException("pgType: " + pgType);
        }

        return result;
    }
}
