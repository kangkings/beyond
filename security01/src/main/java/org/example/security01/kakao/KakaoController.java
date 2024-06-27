package org.example.kakao.member;

import lombok.RequiredArgsConstructor;
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
    @GetMapping("/redirect")
    public ResponseEntity<String> redirect(
            @RequestParam(name = "code") String code

    ){
        String accessToken = kakaoService.getKakaoToken(code);
        kakaoService.getUserInfo(accessToken);

        // 회원가입 여부 확인

        //JWT 토큰 발급


        return ResponseEntity.ok(accessToken);
    }
}
