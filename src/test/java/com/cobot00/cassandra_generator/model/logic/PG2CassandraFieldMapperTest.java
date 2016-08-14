package com.cobot00.cassandra_generator.model.logic;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cobot00.cassandra_generator.model.CassandraDataType;

public class PG2CassandraFieldMapperTest {

    @Test
    public void getType() {
        //integer
        assertThat(PG2CassandraFieldMapper.getTypeForJava("smallint"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("integer"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("bigint"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("int2"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("int4"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("int8"), is(CassandraDataType.INT));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("int"), is(CassandraDataType.INT));

        // float
        assertThat(PG2CassandraFieldMapper.getTypeForJava("real"), is(CassandraDataType.DOUBLE));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("double precision"), is(CassandraDataType.DOUBLE));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("numeric"), is(CassandraDataType.BIG_DECIMAL));

        // string
        assertThat(PG2CassandraFieldMapper.getTypeForJava("varchar"), is(CassandraDataType.STRING));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("character varying"), is(CassandraDataType.STRING));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("text"), is(CassandraDataType.STRING));

        // date & timestamp
        assertThat(PG2CassandraFieldMapper.getTypeForJava("date"), is(CassandraDataType.LOCAL_DATE));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("timestamp with time zone"),
                is(CassandraDataType.LOCAL_DATE_TIME));
        assertThat(PG2CassandraFieldMapper.getTypeForJava("timestamp without time zone"),
                is(CassandraDataType.LOCAL_DATE_TIME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTypeWhenError() {
        PG2CassandraFieldMapper.getTypeForJava("sometype");
    }
}
