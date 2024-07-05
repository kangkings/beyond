package org.example.tddbackend.post;

import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.post.model.Post;
import org.example.tddbackend.post.model.PostCreateReq;
import org.example.tddbackend.post.model.PostCreateRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Test
    void postService_create_success(){
        PostCreateReq req = PostCreateReq.builder()
                .memberIdx(1L)
                .contents("aaaa")
                .build();

        Post post = Post.builder()
                .idx(1L)
                .contents("aaaa")
                .build();

        given(postRepository.save(any(Post.class))).willReturn(post);

        PostCreateRes res = postRepository.save(post).toPostCreateRes();

        assertNotNull(res);
        assertEquals(1L, res.getIdx());
        assertEquals("aaaa", res.getContents());
    }

}