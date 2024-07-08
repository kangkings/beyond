package org.example.tddbackend.likes;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tddbackend.likes.LikesRepository;
import org.example.tddbackend.likes.model.Likes;
import org.example.tddbackend.likes.model.LikesCreateReq;
import org.example.tddbackend.likes.model.LikesCreateRes;
import org.example.tddbackend.likes.model.LikesReadRes;
import org.example.tddbackend.member.MemberRepository;
import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.post.PostRepository;
import org.example.tddbackend.post.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public String create(LikesCreateReq req) {
        Member member = memberRepository.findById(req.getMemberIdx()).get();
        Post post = postRepository.findById(req.getPostIdx()).get();
        Likes likes = likesRepository.findByMemberAndPost(member,post);
        if (likes != null && likes.getStatus()){
            likesRepository.save(Likes.builder()
                            .idx(likes.getIdx())
                            .status(false)
                            .member(likes.getMember())
                            .post(likes.getPost())
                    .build());

            post.subLikesCount();
            postRepository.save(post);
        }else {
            LikesCreateRes res = likesRepository.save(Likes.builder()
                            .member(member)
                            .post(post)
                    .build()).toLikesCreateRes();
            post.addLikesCount();
            postRepository.save(post);
            if (res == null){
                return "좋아요 처리 실패";
            }
        }

        return "좋아요 처리 성공";
    }

//    public LikesReadRes read(Long idx) {
//
//        Optional<Likes> sqlRes = likesRepository.findById(idx);
//        if (sqlRes.isEmpty()){
//            return null;
//        }
//        return sqlRes.get().toLikesReadRes();
//    }
//
//    public List<LikesReadRes> readAll(){
//        List<Likes> sqlRes = likesRepository.findAll();
//        List<LikesReadRes> res = new ArrayList<>();
//        for (Likes m : sqlRes){
//            res.add(m.toLikesReadRes());
//        }
//
//        return res;
//    }

}
