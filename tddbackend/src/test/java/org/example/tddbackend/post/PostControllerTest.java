package org.example.tddbackend.post;

import org.example.tddbackend.post.model.PostCreateReq;
import org.example.tddbackend.post.model.PostCreateRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    void postController_create_success(){
        PostCreateReq req = PostCreateReq.builder()
                .memberIdx(1L)
                .contents("zzzz")
                .build();

        PostCreateRes serviceRes = PostCreateRes.builder()
                .idx(1L)
                .contents("zzzz")
                .build();
        given(postService.create(any(PostCreateReq.class))).willReturn(serviceRes);

        PostCreateRes res = postService.create(req);

        assertNotNull(res);
        assertEquals(1L, res.getIdx());
        assertEquals("zzzz", res.getContents());


    }

}