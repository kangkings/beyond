package member;

import java.sql.*;

public class UserDao {
    public Boolean read(UserDto dto) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.0.128:10100/web",
                    "kts", "qwer1234"
            );
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM member WHERE id='"+dto.getId()+"' AND pw='"+dto.getPw()+"'");


            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return false;
    }

    public Boolean create(UserDto dto) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rs2;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.0.128:10100/web",
                    "kts", "qwer1234"
            );
            stmt = connection.createStatement();

            rs2 = stmt.executeUpdate("INSERT INTO web.member (id,pw) values('"+dto.getId()+"', '"+dto.getPw()+"' )");


            if (rs2 > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return false;
    }
}
