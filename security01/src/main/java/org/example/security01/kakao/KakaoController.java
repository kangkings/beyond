package org.example.security01.kakao;

import lombok.RequiredArgsConstructor;
import org.example.security01.jwt.JwtUtil;
import org.example.security01.member.model.Member;
import org.example.security01.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao")
public class KakaoController {

    //private final아니면 생성자 생성 안해줌
    private final KakaoService kakaoService;
    private final MemberService memberService;
    private final JwtUtil jwtUtil;
    @GetMapping("/redirect")
    public ResponseEntity<String> redirect(
            @RequestParam(name = "code") String code

    ){
        String accessToken = kakaoService.getKakaoToken(code);
        String nickname = kakaoService.getUserInfo(accessToken);

        // 회원가입 여부 확인
        Member member = memberService.getMemberbyEmail(nickname);
        if (member == null){
            memberService.signup(member.getEmail(), null);
        }

        //JWT 토큰 발급
        String role = member.getRole();
        String username = member.getEmail();
        String token = jwtUtil.createToken(username, role);



        return ResponseEntity.ok(accessToken);
    }
}
