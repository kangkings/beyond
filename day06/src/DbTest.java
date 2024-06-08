import java.sql.*;

// DB 서버 준비
/*
	DB 서버에 web DB 생성
	이니셜 사용자 추가
	web DB에 이니셜 사용자한테 권한
	게시판 테이블 생성
		mysql
			CREATE DATABASE web;
			CREATE USER 'sjb'@'%' IDENTIFIED BY 'qwer1234';
			GRANT ALL PRIVILEGES ON web.* TO 'sjb'@'%';
			FLUSH PRIVILEGES;
			CREATE TABLE web.board (
				idx INT AUTO_INCREMENT PRIMARY KEY,
				title VARCHAR(50),
				contents VARCHAR(500)
			);
*/


public class DbTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.0.128:10100/web",
                    "kts", "qwer1234"
            );
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
