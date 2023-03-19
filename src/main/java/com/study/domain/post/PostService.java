package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor    // final로 선언된 모든 멤버 -> 생성자 만들어줌.
public class PostService {
    private final PostMapper postMapper;

    @Transactional
    public Long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }

    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    public Long deletePost(long id){
        postMapper.deleteById(id);
        return id;
    }

    public List<PostResponse> findAllPost() {
        return postMapper.findAll();
    }

}
