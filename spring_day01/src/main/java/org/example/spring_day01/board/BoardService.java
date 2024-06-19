package org.example.spring_day01.board;

import org.example.spring_day01.board.model.BoardCreateReq;
import org.example.spring_day01.board.model.BoardCreateRes;
import org.example.spring_day01.board.model.BoardReadRes;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public BoardCreateRes create(BoardCreateReq boardCreateReq){
        BoardCreateRes boardCreateRes = new BoardCreateRes();
        boardCreateRes.setTitle(boardCreateReq.getTitle()+"변경됨");
        return boardCreateRes;
    }

    public String delete(int number) {
        return number+"번 게시글 삭제";
    }

    public BoardReadRes view(int number) {
        BoardReadRes boardReadRes = new BoardReadRes();
        boardReadRes.setTitle(number+"번 게시글 제목");
        boardReadRes.setContents(number+"번 게시글 내용");
        return boardReadRes;
    }
}
