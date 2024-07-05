package org.example.tddbackend.post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.member.model.Member;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String contents;


    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Likes> likesList;

    public PostCreateRes toPostCreateRes(){
        return PostCreateRes.builder()
                .idx(idx)
                .contents(contents)
                .build();
    }

    public PostReadRes toPostReadRes(){
        return PostReadRes.builder()
                .idx(idx)
                .contents(contents)
                .build();
    }
}
