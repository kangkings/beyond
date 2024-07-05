package org.example.tddbackend.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.post.model.Post;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberReadRes {
    private Long idx;
    private String email;

}
