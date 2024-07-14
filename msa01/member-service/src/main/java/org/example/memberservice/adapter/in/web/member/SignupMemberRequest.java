package org.example.memberservice.adapter.in.web.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupMemberRequest {
    private String email;
    private String name;
}
