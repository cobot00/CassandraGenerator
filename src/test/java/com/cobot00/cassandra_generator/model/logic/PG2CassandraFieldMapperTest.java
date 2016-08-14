package com.cobot00.cassandra_generator.model.logic;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cobot00.cassandra_generator.model.CassandraFieldType;

public class PG2CassandraFieldMapperTest {

    @Test
    public void getType() {
        PG2CassandraFieldMapper target = new PG2CassandraFieldMapper();

        //integer
        assertThat(target.getTypeForJava("smallint"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("integer"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("bigint"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("int2"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("int4"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("int8"), is(CassandraFieldType.INT));
        assertThat(target.getTypeForJava("int"), is(CassandraFieldType.INT));

        // float
        assertThat(target.getTypeForJava("real"), is(CassandraFieldType.DOUBLE));
        assertThat(target.getTypeForJava("double precision"), is(CassandraFieldType.DOUBLE));
        assertThat(target.getTypeForJava("numeric"), is(CassandraFieldType.BIG_DECIMAL));

        // string
        assertThat(target.getTypeForJava("varchar"), is(CassandraFieldType.STRING));
        assertThat(target.getTypeForJava("character varying"), is(CassandraFieldType.STRING));
        assertThat(target.getTypeForJava("text"), is(CassandraFieldType.STRING));

        // date & timestamp
        assertThat(target.getTypeForJava("date"), is(CassandraFieldType.LOCAL_DATE));
        assertThat(target.getTypeForJava("timestamp with time zone"), is(CassandraFieldType.LOCAL_DATE_TIME));
        assertThat(target.getTypeForJava("timestamp without time zone"), is(CassandraFieldType.LOCAL_DATE_TIME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTypeWhenError() {
        PG2CassandraFieldMapper target = new PG2CassandraFieldMapper();
        target.getTypeForJava("sometype");
    }
}
