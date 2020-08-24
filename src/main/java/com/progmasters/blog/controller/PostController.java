package com.progmasters.blog.controller;

import com.progmasters.blog.domain.Post;
import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.dto.PostDetailsItem;
import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.dto.PostListItem;
import com.progmasters.blog.repository.PostRepository;
import com.progmasters.blog.service.PostService;
import com.progmasters.blog.validator.PostValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final PostValidator postValidator;
    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostController(PostService postService, PostValidator postValidator) {
        this.postService = postService;
        this.postValidator = postValidator;
    }

    @InitBinder(value = {"postFormItem"})
    public void init(WebDataBinder binder) {
        binder.addValidators(postValidator);
    }


    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostFormItem postFormItem) {
        Long postId = postService.createPost(postFormItem);
        logger.debug("Post successfully created with id: " + postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostListItem>> getAllPosts() {
        List<PostListItem> postsToList = postService.selectAllPosts();
        return new ResponseEntity<>(postsToList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailsItem> getPost(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostDetails(id), HttpStatus.OK);
    }
}
