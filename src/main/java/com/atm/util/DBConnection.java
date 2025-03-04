package com.atm.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/atm_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "nziza";
    private static final String PASSWORD = "co2hno3";

    private static HikariDataSource dataSource;

    static {
        try {
            // Explicitly register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // HikariCP Configuration
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(URL);
            config.setUsername(USER);
            config.setPassword(PASSWORD);
            config.setMaximumPoolSize(10);  // Max connections in the pool
            config.setMinimumIdle(2);       // Min idle connections
            config.setIdleTimeout(30000);   // 30 seconds
            config.setConnectionTimeout(30000); // 30 seconds
            config.setMaxLifetime(1800000); // 30 minutes

            // Create the HikariDataSource
            dataSource = new HikariDataSource(config);

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver Not Found!");
            e.printStackTrace();
        }
    }

    // Get connection from HikariCP pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Close the HikariCP pool when shutting down the app
    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
