package com.progmasters.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.progmasters.blog.domain.Post;

import java.time.LocalDateTime;

public class PostListItem {
    private Long id;
    private String url;
    private String title;
    private String text;
    @JsonFormat(pattern = "YYYY.MMM dd - HH:mm")
    private LocalDateTime createdAt;

    public PostListItem(Post post) {
        this.id = post.getId();
        this.url = post.getUrl();
        this.title = post.getTitle();
        this.text = post.getText();
        this.createdAt = post.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
