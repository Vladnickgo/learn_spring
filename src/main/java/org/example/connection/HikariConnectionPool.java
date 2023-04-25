package org.example.connection;

import com.zaxxer.hikari.HikariDataSource;
import org.example.exception.DataBaseRuntimeException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HikariConnectionPool {
    private final HikariDataSource dataSource;

    public HikariConnectionPool(String configFileName) {
        ResourceBundle resource = ResourceBundle.getBundle(configFileName);
        try {
            dataSource = new HikariDataSource();
            dataSource.setDriverClassName(resource.getString("dataSource.driver"));
            dataSource.setJdbcUrl(resource.getString("dataSource.url"));
            dataSource.setUsername(resource.getString("dataSource.user"));
            dataSource.setPassword(resource.getString("dataSource.password"));
            dataSource.setMinimumIdle(Integer.parseInt(resource.getString("dataSource.minimumIdle")));
            dataSource.setMaximumPoolSize(Integer.parseInt(resource.getString("dataSource.MaximumPoolSize")));
            dataSource.setLoginTimeout(Integer.parseInt(resource.getString("dataSource.setLoginTimeout")));
        } catch (SQLException e) {
            throw new DataBaseRuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new DataBaseRuntimeException(e);
        }
    }
}
