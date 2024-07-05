package org.example.tddbackend.likes;

import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
    Likes findByMemberAndPost(Member member, Post post);
}
