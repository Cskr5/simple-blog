package com.progmasters.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.progmasters.blog.domain.Comment;

import java.time.LocalDateTime;

public class CommentDetailsItem {
    private String author;
    private String text;
    @JsonFormat(pattern = "YYYY.MMM dd - HH:mm")
    private LocalDateTime createdAt;

    public CommentDetailsItem(Comment comments) {
        this.author = comments.getAuthor();
        this.text = comments.getText();
        this.createdAt = comments.getCreatedAt();
    }

    public CommentDetailsItem(String author, String text, LocalDateTime createdAt) {
        this.author = author;
        this.text = text;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
