package org.example.tddbackend.likes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.post.model.Post;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class LikesReadRes {
    private Long idx;
    private Member member;
    private Post post;
}
