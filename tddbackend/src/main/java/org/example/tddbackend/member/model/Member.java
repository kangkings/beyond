package org.example.tddbackend.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.post.model.Post;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;

    @Builder.Default
    private String role = "ROLE_USER";

    @OneToMany(mappedBy = "member")
    private List<Likes> likesList;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;

    public MemberCreateRes toMemberCreateRes(){
        return MemberCreateRes.builder()
                .idx(idx)
                .email(email)
                .build();
    }

    public MemberReadRes toMemberReadRes(){
        return MemberReadRes.builder()
                .idx(idx)
                .email(email)
                .build();
    }

    public PostLoginRes toPostLoginRes(){
        return PostLoginRes.builder()
                .email(email)
                .build();
    }

}
