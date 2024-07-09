package com.example.memberapi.member.model;


import com.example.memberapi.member.model.response.PostSignupRes;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Builder.Default
    private String role = "ROLE_USER";

    public PostSignupRes toPostSignupRes(){
        return PostSignupRes.builder()
                .id(id)
                .email(email)
                .build();
    }

}
