package org.example.board.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.board.DataSourceConfig;
import org.example.board.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    public List<BoardDto> read(BoardDto dto) {

        DataSourceConfig config;
        config = DataSourceConfig.getInstance();


        List<BoardDto> resultList = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = config.getDataSource().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM board");

            while(rs.next()){
                BoardDto dto1 = new BoardDto(rs.getString("title"), rs.getString("contents"));
                resultList.add(dto1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) { } // ignore

                connection = null;
            }
        }
        return resultList;
    }

    public Boolean create(BoardDto dto) {

        DataSourceConfig config;
        config = DataSourceConfig.getInstance();

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rs2;
        try {
            connection = config.getDataSource().getConnection();
            stmt = connection.createStatement();

            rs2 = stmt.executeUpdate("INSERT INTO board (title,contents) values('"+dto.getTitle()+"', '"+dto.getContents()+"' )");

            if (rs2 > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) { } // ignore

                connection = null;
            }
        }
        return false;
    }
}
