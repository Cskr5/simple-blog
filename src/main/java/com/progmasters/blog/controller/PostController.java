package com.progmasters.blog.controller;

import com.progmasters.blog.domain.Post;
import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.dto.PostListItem;
import com.progmasters.blog.repository.PostRepository;
import com.progmasters.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostFormItem postFormItem) {
        postService.createPost(postFormItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostListItem>> getAllPosts() {
        List<PostListItem> postsToList = postService.selectAllPosts();
        return new ResponseEntity<>(postsToList, HttpStatus.OK);
    }
}
