package com.cobot00.cassandra_generator.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private DBUtils() {
        // no instance
    }

    public static void closeIfNotNull(Connection conn) {
        if (conn == null) {
            return;
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeIfNotNull(Statement s) {
        if (s == null) {
            return;
        }

        try {
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeIfNotNull(PreparedStatement ps) {
        if (ps == null) {
            return;
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
