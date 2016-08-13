package com.cobot00.cassandra_generator.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class SimpleDao<E, T> {

    public List<E> select() {
        return select(null);
    }

    public List<E> select(List<T> conditions) {
        final List<E> result = new ArrayList<E>();

        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = getEntry().getConnection();
            ps = connection.prepareStatement(generateSql());
            setConditions(ps, conditions);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(createEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            DBUtils.closeIfNotNull(ps);
            DBUtils.closeIfNotNull(connection);
        }

        return result;
    }

    protected abstract DBEntry getEntry();

    protected abstract String generateSql();

    protected void setConditions(PreparedStatement ps, List<T> conditions) throws SQLException {
        // if you need override
    }

    protected abstract E createEntity(ResultSet rs) throws SQLException;

}
