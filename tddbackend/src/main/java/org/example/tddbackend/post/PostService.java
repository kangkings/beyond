package org.example.tddbackend.post;

import lombok.RequiredArgsConstructor;
import org.example.tddbackend.post.PostRepository;
import org.example.tddbackend.post.model.Post;
import org.example.tddbackend.post.model.PostCreateReq;
import org.example.tddbackend.post.model.PostCreateRes;
import org.example.tddbackend.post.model.PostReadRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public PostCreateRes create(PostCreateReq req) {
        PostCreateRes res = postRepository.save(req.toPost()).toPostCreateRes();
        return res;
    }

    public PostReadRes read(Long idx) {

        Optional<Post> sqlRes = postRepository.findById(idx);
        if (sqlRes.isEmpty()){
            return null;
        }
        return sqlRes.get().toPostReadRes();
    }

    public List<PostReadRes> readAll(){
        List<Post> sqlRes = postRepository.findAll();
        List<PostReadRes> res = new ArrayList<>();
        for (Post m : sqlRes){
            res.add(m.toPostReadRes());
        }

        return res;
    }
}
