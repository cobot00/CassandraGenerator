package com.cobot00.cassandra_generator.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cobot00.cassandra_generator.model.dto.KeyColumnEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PostgreSQLKeyColumnDao extends SimpleDao<KeyColumnEntity, String> {

    private static final String CONSTRAINT_NAME = "CONSTRAINT_NAME";
    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String CONSTRAINT_TYPE = "CONSTRAINT_TYPE";

    @Autowired
    private final DBEntry entry;

    @Override
    protected DBEntry getEntry() {
        return entry;
    }

    /*
      SELECT kc.constraint_name, kc.column_name, tc.constraint_type
      FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE KC
      INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS TC
      ON kc.table_name = tc.table_name AND kc.constraint_name = tc.constraint_name
      WHERE kc.table_name = 'data_types'
      ORDER BY kc.constraint_name, kc.ordinal_position
     */
    @Override
    protected String generateSql() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("kc.constraint_name, kc.column_name, tc.constraint_type ");
        sb.append("FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE KC ");
        sb.append("INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS TC ");
        sb.append("ON kc.table_name = tc.table_name AND kc.constraint_name = tc.constraint_name ");
        sb.append("WHERE kc.table_name = ? ");
        sb.append("ORDER BY kc.constraint_name, kc.ordinal_position");

        return sb.toString();
    }

    @Override
    protected void setConditions(PreparedStatement ps, List<String> conditions) throws SQLException {
        int index = 0;
        ps.setString(++index, conditions.get(0));
    }

    @Override
    protected KeyColumnEntity createEntity(ResultSet rs) throws SQLException {
        return new KeyColumnEntity(rs.getString(CONSTRAINT_NAME), rs.getString(COLUMN_NAME),
                rs.getString(CONSTRAINT_TYPE));
    }

}
