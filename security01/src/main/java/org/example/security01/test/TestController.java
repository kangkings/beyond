package org.example.security01.test;

import org.example.security01.member.model.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/ex01")
    public ResponseEntity<CustomUserDetails> ex01(){
        System.out.println("여기까진 옴");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //로그인한 유저 정보를 세션에서 가져옴(Object)
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }
}
