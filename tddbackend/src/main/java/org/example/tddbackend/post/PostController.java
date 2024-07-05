package org.example.tddbackend.post;

import lombok.RequiredArgsConstructor;
import org.example.tddbackend.post.model.PostCreateReq;
import org.example.tddbackend.post.model.PostCreateRes;
import org.example.tddbackend.post.model.PostReadRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<PostCreateRes> create(
            @RequestBody PostCreateReq req
    ){
        PostCreateRes res = postService.create(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<PostReadRes> read(
            @PathVariable(name = "idx") Long idx
    ){
        PostReadRes res = postService.read(idx);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/read")
    public ResponseEntity<List<PostReadRes>> readAll(){
        List<PostReadRes> res = postService.readAll();
        return ResponseEntity.ok(res);
    }
}
