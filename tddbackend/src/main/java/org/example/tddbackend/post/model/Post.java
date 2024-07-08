package org.example.tddbackend.post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.member.model.Member;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String contents;

    @ColumnDefault(value = "0")
    @Version //낙관적 락
    private Integer likesCount;

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
                .likesCount(likesList.size())
                .writer(member.getEmail())
                .build();
    }

    public PostReadRes toPostReadRes(Integer count){
        return PostReadRes.builder()
                .idx(idx)
                .contents(contents)
                .likesCount(count)
                .writer(member.getEmail())
                .build();
    }

    public void addLikesCount(){
        this.likesCount = this.likesCount + 1;
    }

    public void subLikesCount(){
        this.likesCount = this.likesCount - 1;
    }
}
