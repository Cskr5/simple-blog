package com.progmasters.blog.service;

import com.progmasters.blog.domain.Post;
import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long createPost(PostFormItem postFormItem) {
        Post post = new Post(postFormItem);
        postRepository.save(post);
        return post.getId();
    }
}
