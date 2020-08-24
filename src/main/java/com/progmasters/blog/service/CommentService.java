package com.progmasters.blog.service;

import com.progmasters.blog.domain.Comment;
import com.progmasters.blog.domain.Post;
import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.dto.PostDetailsItem;
import com.progmasters.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {
    private CommentRepository commentRepository;
    private PostService postService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public void createComment(CommentDetailsItem commentDetailsItem, Long postId) {
        Post post = postService.getPost(postId);
        Comment comment = new Comment(commentDetailsItem,post);
        commentRepository.save(comment);
    }
}
