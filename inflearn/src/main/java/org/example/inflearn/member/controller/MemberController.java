package org.example.inflearn.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.inflearn.common.BaseResponse;
import org.example.inflearn.common.BaseResponseStatus;
import org.example.inflearn.member.model.request.PostLoginReq;
import org.example.inflearn.member.model.request.PostSignupReq;
import org.example.inflearn.member.model.response.PostLoginRes;
import org.example.inflearn.member.model.response.PostSignupRes;
import org.example.inflearn.member.service.EmailVerifiyService;
import org.example.inflearn.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final EmailVerifiyService emailVerifiyService;

    //회원가입
    @PostMapping("/signup")
    public BaseResponse<PostSignupRes> signup(
            @RequestBody PostSignupReq req
            ){
        PostSignupRes res = memberService.signup(req);
        String uuid = emailVerifiyService.saveUuid(req.getEmail());
        emailVerifiyService.sendEmail(req.getEmail(), uuid);
        return new BaseResponse(res);

    }

    @GetMapping("/verify")
    public String login(
            String email, String uuid
    ){
        if (emailVerifiyService.checkUuid(email, uuid)){
            memberService.editEnable(email);
            return "인증 성공";

        }else {
            return "이메일 인증이 올바르지 않습니다.";

        }
    }

    @PostMapping("/login")
    public BaseResponse<PostLoginRes> login(
            @RequestBody PostLoginReq req
            ){
        System.out.println("여기로옴");
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
