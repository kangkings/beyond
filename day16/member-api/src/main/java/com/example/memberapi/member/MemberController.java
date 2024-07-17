package com.example.memberapi.member;


import com.example.memberapi.member.model.request.PostSignupReq;
import com.example.memberapi.member.model.response.PostSignupRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/test")
    public ResponseEntity<String> test(
            Long idx
    ){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            String hostName = localHost.getHostName();
            return ResponseEntity.ok("회원 번호 : "+idx+"IP Address: " + ipAddress + "Host Name: " + hostName);
        } catch (UnknownHostException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<PostSignupRes> signup(
            @RequestBody PostSignupReq req
    ){
        PostSignupRes res = memberService.signup(req);
        return ResponseEntity.ok(res);

    }
}
