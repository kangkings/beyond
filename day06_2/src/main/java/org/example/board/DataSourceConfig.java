package org.example.board;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceConfig {
    private static DataSourceConfig instance;
    private HikariDataSource dataSource;
    private DataSourceConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://192.168.0.128:10100/web");
        config.setUsername("kts");
        config.setPassword("qwer1234");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        this.dataSource = new HikariDataSource(config);
    }

    public static DataSourceConfig getInstance() {
        if(instance == null) {
            return new DataSourceConfig();
        }
        return instance;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }
}
