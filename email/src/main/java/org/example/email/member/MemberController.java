package org.example.email.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<String> signup(String username, String password) {

        //메일시스템(메일서버, 메일 클라이언트, SMTP, POP3, IMAP)
        //werv ulgk fvrr fbst
        //UUID생성해서 메일로 전송하고 UUID반환
        String uuid = memberService.sendEmail(username);
        //회원 정보 일단 저장
        memberService.signup(username, password);

        //UUID를 DB에 저장

        return ResponseEntity.ok("성공");
    }

}
