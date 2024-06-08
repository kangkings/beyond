package org.example.board.servlet;

import org.checkerframework.checker.units.qual.A;
import org.example.UserDao;
import org.example.UserDto;
import org.example.board.dao.BoardDao;
import org.example.board.dto.BoardDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.StandardProtocolFamily;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    BoardDao boardDao;

    @Override
    public void init() throws ServletException {
        boardDao = new BoardDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BoardDto boardDto = new BoardDto(req.getParameter("title"), req.getParameter("contents"));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        List<BoardDto> resultList = new ArrayList<>();
        resultList = boardDao.read(boardDto);
        for (int i = 0; i < resultList.size(); i++) {

            out.println(resultList.get(i).getTitle());
            out.println(resultList.get(i).getContents());
            out.println("<br>");

        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BoardDto boardDto = new BoardDto(req.getParameter("title"), req.getParameter("contents"));


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if(boardDao.create(boardDto)) {
            out.println("게시글 등록 성공");
        } else {
            out.println("게시글 등록 실패!!!");
        }
    }
}
