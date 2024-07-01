package org.example.inflearn.member.model;


import jakarta.persistence.*;
import lombok.*;
import org.example.inflearn.member.model.response.PostSignupRes;
import org.hibernate.annotations.ColumnDefault;

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
    private Boolean enabled;
    private String name;
    private String password;
    private String profile_image;

    @Builder.Default
    private String role = "ROLE_USER";

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "member")
    private EmailVerify emailVerify;
    public PostSignupRes toPostSignupRes(){
        return PostSignupRes.builder()
                .id(id)
                .email(email)
                .name(name)
                .build();
    }

}
