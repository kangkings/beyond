package org.example;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;


public class DbcpTest {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://10.10.10.10:3306/web");
        config.setUsername("sjb");
        config.setPassword("qwer1234");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);

        HikariDataSource dataSource = new HikariDataSource(config);


        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM board");

            while (rs.next()) {
                String idx = rs.getString("idx");
                String title = rs.getString("title");
                String contents = rs.getString("contents");

                System.out.println(idx);
                System.out.println(title);
                System.out.println(contents);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
