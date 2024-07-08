package org.example.tddbackend.post;

import org.example.tddbackend.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    //JPQL이기 떄문에 SQL과 약간씩 다르다.
    //해당 쿼리의 주요 부분들은 Entity 클래스와 그 변수의 이름을 사용한다.(JPQL문법에 따름)
    @Query("SELECT COUNT(*) FROM Post p JOIN FETCH p.likesList l WHERE l.post.idx = p.idx ")
    public Integer findByIdWithCount(Long postIdx);

}
