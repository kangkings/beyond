package org.example.tddbackend.likes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.post.model.Post;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Builder.Default
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_idx")
    private Post post;

    public LikesCreateRes toLikesCreateRes(){
        return LikesCreateRes.builder()
                .member(member)
                .post(post)
                .build();

    }

}
