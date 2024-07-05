package org.example.tddbackend.member;

import lombok.RequiredArgsConstructor;
import org.example.tddbackend.member.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<MemberCreateRes> create(
            @RequestBody MemberCreateReq req
            ){
        MemberCreateRes res = memberService.create(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<MemberReadRes> read(
            @PathVariable(name = "idx") Long idx
    ){
        MemberReadRes res = memberService.read(idx);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/read")
    public ResponseEntity<List<MemberReadRes>> readAll(){
        List<MemberReadRes> res = memberService.readAll();
        return ResponseEntity.ok(res);
    }
}

