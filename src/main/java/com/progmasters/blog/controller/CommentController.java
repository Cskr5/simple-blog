package com.progmasters.blog.controller;

import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.service.CommentService;
import com.progmasters.blog.validator.CommentValidator;
import com.progmasters.blog.validator.PostValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts/comment")
public class CommentController {

    private CommentService commentService;
    private final CommentValidator commentValidator;
    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public CommentController(CommentService commentService, CommentValidator commentValidator) {
        this.commentService = commentService;
        this.commentValidator = commentValidator;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> createComment(@PathVariable Long postId, @Valid @RequestBody CommentDetailsItem commentDetailsItem) {
        commentService.createComment(commentDetailsItem, postId);
        logger.info("New comment is created");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
