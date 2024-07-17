package com.example.postapi.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping("/test")
    public ResponseEntity<String> test(
            @RequestHeader("X-User-Username") String username,
            @RequestHeader("X-User-Role") String role,
            Long idx
    ){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            String hostName = localHost.getHostName();
            return ResponseEntity.ok("게시글 번호 : "+idx+"IP Address: " + ipAddress + "Host Name: " + hostName);
        } catch (UnknownHostException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
