package org.example.tddbackend.likes;

import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.likes.model.LikesCreateReq;
import org.example.tddbackend.likes.model.LikesCreateRes;
import org.example.tddbackend.likes.model.LikesCreateReq;
import org.example.tddbackend.likes.model.LikesCreateRes;
import org.example.tddbackend.likes.model.LikesReadRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/create")
    public ResponseEntity<String> create(
            @RequestBody LikesCreateReq req
    ){
        String res = likesService.create(req);
        return ResponseEntity.ok(res);
    }

//    @GetMapping("/read/{idx}")
//    public ResponseEntity<LikesReadRes> read(
//            @PathVariable(name = "idx") Long idx
//    ){
//        LikesReadRes res = likesService.read(idx);
//        return ResponseEntity.ok(res);
//    }
//
//    @GetMapping("/read")
//    public ResponseEntity<List<LikesReadRes>> readAll(){
//        List<LikesReadRes> res = likesService.readAll();
//        return ResponseEntity.ok(res);
//    }
}
