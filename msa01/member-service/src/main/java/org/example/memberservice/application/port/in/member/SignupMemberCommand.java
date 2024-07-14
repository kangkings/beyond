package org.example.memberservice.application.port.in.member;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
public class SignupMemberCommand {
    private String email;
    private String name;
}
