package com.cobot00.cassandra_generator.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cobot00.cassandra_generator.model.dto.ColumnEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PostgreSQLDao extends SimpleDao<ColumnEntity, String> {

    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String DATA_TYPE = "DATA_TYPE";
    private static final String COLUMN_DEFAULT = "COLUMN_DEFAULT";
    private static final String IS_NULLABLE = "IS_NULLABLE";
    private static final String CHARACTER_MAXIMUM_LENGTH = "CHARACTER_MAXIMUM_LENGTH";
    private static final String NUMERIC_PRECISION = "NUMERIC_PRECISION";
    private static final String NUMERIC_SCALE = "NUMERIC_SCALE";

    @Autowired
    private final DBEntry entry;

    @Override
    protected DBEntry getEntry() {
        return entry;
    }

    @Override
    protected String generateSql() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("table_name, ordinal_position, column_name, data_type,");
        sb.append("column_default, is_nullable, character_maximum_length,");
        sb.append("numeric_precision, numeric_scale ");
        sb.append("FROM INFORMATION_SCHEMA.COLUMNS ");
        sb.append("WHERE table_name = ? ");
        sb.append("ORDER BY table_name, ordinal_position");

        return sb.toString();
    }

    @Override
    protected void setConditions(PreparedStatement ps, List<String> conditions) throws SQLException {
        int index = 0;
        ps.setString(++index, conditions.get(0));
    }

    @Override
    protected ColumnEntity createEntity(ResultSet rs) throws SQLException {
        //final H2ColumnType columnType = MySQLColumnTypeConverter.convert(rs.getString(DATA_TYPE));

        final ColumnEntity result = new ColumnEntity();
        result.setColumnName(rs.getString(COLUMN_NAME));
        result.setDataType(rs.getString(DATA_TYPE));
        result.setNullable(rs.getString(IS_NULLABLE).equals("NO"));
        result.setColumnDefault(rs.getString(COLUMN_DEFAULT));
        result.setNumericPrecision(rs.getInt(NUMERIC_PRECISION));
        result.setCharacterMaximumLength(rs.getInt(CHARACTER_MAXIMUM_LENGTH));
        result.setNumericScale(rs.getInt(NUMERIC_SCALE));

        return result;
    }
}
