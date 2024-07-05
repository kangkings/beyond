package org.example.tddbackend.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.member.model.Member;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class PostCreateReq {
    private Long memberIdx;
    private String contents;

    public Post toPost(){
        return Post.builder()
                .member(Member.builder().idx(memberIdx).build())
                .contents(contents)
                .build();
    }
}
