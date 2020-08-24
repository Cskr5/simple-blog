package com.progmasters.blog.service;

import com.progmasters.blog.domain.Comment;
import com.progmasters.blog.domain.Post;
import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.dto.PostDetailsItem;
import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.dto.PostListItem;
import com.progmasters.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
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

    public List<PostListItem> selectAllPosts() {
        return postRepository.findAllByDateDesc()
                .stream()
                .map(PostListItem::new)
                .collect(Collectors.toList());
    }

    public PostDetailsItem getPostDetails(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with given Id: " + id));
        return new PostDetailsItem(post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with given Id: " + id));
    }
}
