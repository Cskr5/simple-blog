package com.progmasters.blog.controller;

import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> createComment(@PathVariable Long postId, @RequestBody CommentDetailsItem commentDetailsItem) {
        commentService.createComment(commentDetailsItem,postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
