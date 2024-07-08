package org.example.tddbackend.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.member.model.Member;

import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PostReadRes {
    private Long idx;
    private String contents;
    private Integer likesCount;
    private String writer;
}
