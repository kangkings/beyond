package org.example.servlet;
import org.example.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.BaseResponseMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/member")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Json형태의 요청 받기
        BufferedReader br = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = br.readLine())!= null){
            json.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();
        PostMemberReq dto = mapper.readValue( json.toString(), PostMemberReq.class);
        System.out.println(json.toString());



        //회원가입 dao 메소드 실행

        Boolean res = true;
        String jsonResponse;
        // json형식으로 응답
        if (res){
            BaseResponseMessage baseResponseMessage = BaseResponseMessage.HTTP_SUCCESS;
            jsonResponse = mapper.writeValueAsString(baseResponseMessage);

        }else {
            BaseResponseMessage baseResponseMessage = BaseResponseMessage.HTTP_SUCCESS;
            jsonResponse = mapper.writeValueAsString(baseResponseMessage);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
