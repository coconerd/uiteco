/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 *
 * @author nddmi
 */
public class ConnectionManager {

    public static PoolDataSource connectionPool;

    static {
        setConnectionPool(PoolDataSourceFactory.getPoolDataSource());

        try {
            connectionPool.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            connectionPool.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
            connectionPool.setUser("DO_AN");
            connectionPool.setPassword("password");
            connectionPool.setInitialPoolSize(1);
            connectionPool.setMinPoolSize(1);
            connectionPool.setMaxPoolSize(20);

        } catch (SQLException e) {
<<<<<<< HEAD
            System.out.println("Failed to connect to database");
=======
            System.out.println("ConnectionManager: Failed to connect db");
>>>>>>> ducminh
            e.printStackTrace();
        }
    }

    public static PoolDataSource getConnectionPool() {
        return connectionPool;
    }

    public static void setConnectionPool(PoolDataSource _dataSource) {
        connectionPool = _dataSource;
    }

<<<<<<< HEAD
    public static Connection getConnection() {
=======
    public static Connection getConnection() throws SQLException {
>>>>>>> ducminh
        try {
            Connection conn = connectionPool.getConnection();
            return conn;
        } catch (SQLException e) {
            // When this error is thrown here, it's most likely that all connections in the connection pool's been occupied.
<<<<<<< HEAD
            e.printStackTrace();
            return null;
=======
            throw e;
>>>>>>> ducminh
        }
    }
}
