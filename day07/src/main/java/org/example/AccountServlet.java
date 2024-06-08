package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String userName = req.getParameter("username");
        Integer money = Integer.parseInt(req.getParameter("money"));
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;


        try{
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.0.128:10100/web",
                    "kts",
                    "qwer1234"
            );

            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT money FROM accounts WHERE username='"+userName+"'");


            if (rs.next()){
                Integer mymoney;
                mymoney = rs.getInt("money");
                if (action.equals("입금")){
                    money = mymoney + money;
                    stmt.executeUpdate("UPDATE accounts SET money="+money+" WHERE username='"+userName+"'");



                }else{
                    money = mymoney - money;
                    stmt.executeUpdate("UPDATE accounts SET money="+money+" WHERE username='"+userName+"'");
                }
                PrintWriter out = resp.getWriter();
                out.println(mymoney);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
