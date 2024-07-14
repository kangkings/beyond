package org.example.memberservice.adapter.in.web.member;

import lombok.RequiredArgsConstructor;
import org.example.memberservice.application.port.in.member.SignupMemberCommand;
import org.example.memberservice.application.port.in.member.SignupMemberUseCase;
import org.example.memberservice.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@WebAdapter
@RequiredArgsConstructor
public class SignupMemberController {
    private final SignupMemberUseCase signupMemberUseCase;

    @PostMapping("/member/signup")
    public void sigunup(
            @RequestBody SignupMemberRequest signupMemberRequest
            ){
        SignupMemberCommand command = SignupMemberCommand.builder()
                .email(signupMemberRequest.getEmail())
                .name(signupMemberRequest.getName())
                .build();
        signupMemberUseCase.sigunupMember(command);

    }
}
