package org.example.spring_day01.board;

import org.example.spring_day01.board.model.BoardCreateReq;
import org.example.spring_day01.board.model.BoardCreateRes;
import org.example.spring_day01.board.model.BoardReadRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BoardCreateRes> create(
            @RequestBody BoardCreateReq boardCreateReq
            ){
        BoardCreateRes boardCreateRes;
        boardCreateRes = boardService.create(boardCreateReq);

        return ResponseEntity.ok(boardCreateRes);

    }

    @GetMapping(value = "/view")
    public ResponseEntity<BoardReadRes> view(
            @RequestParam(name = "number") int number
    ){
        BoardReadRes boardReadRes;
        boardReadRes = boardService.view(number);

        return ResponseEntity.ok(boardReadRes);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(
            @RequestParam(name = "number") int number
    ){
        String res = boardService.delete(number);

        return  ResponseEntity.ok(res);

    }
}
