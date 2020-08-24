package com.progmasters.blog.dto;

import com.progmasters.blog.domain.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDetailsItem {
    private String author;
    private String text;
    private LocalDateTime createdAt;

    public CommentDetailsItem(Comment comments) {
        this.author = comments.getAuthor();
        this.text = comments.getText();
        this.createdAt = comments.getCreatedAt();
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
