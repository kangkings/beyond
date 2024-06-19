package org.example.spring_day01.member;

import org.example.spring_day01.member.model.MemberLoginReq;
import org.example.spring_day01.member.model.MemberSignupReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ex01")
    public String ex01(MemberSignupReq memberSignupReq
    ){
        System.out.println(memberSignupReq.toString());
        String res = memberService.method01();
        return "test";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String signup(
            //해당 어노테이션을 붙이면 JSON은 받을 수 있지만 POM데이터는 못받는다. (떼면 반대)
            @RequestBody MemberSignupReq memberSignupReq
    ){
        System.out.println(memberSignupReq.toString());
        String res = memberService.method01();
        return "test";
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(
            @RequestBody MemberLoginReq memberLoginReq
            ){

        String res = memberService.login(memberLoginReq);

        return ResponseEntity.ok(res);
    }
}
