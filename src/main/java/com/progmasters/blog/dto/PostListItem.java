package com.progmasters.blog.dto;

import com.progmasters.blog.domain.Post;

import java.time.LocalDateTime;

public class PostListItem {
    private String url;
    private String title;
    private String text;
    private LocalDateTime createdAt;

    public PostListItem(String url, String title, String text, LocalDateTime createdAt) {
        this.url = url;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
    }

    public PostListItem(Post post) {
        this.url = post.getUrl();
        this.title = post.getTitle();
        this.text = post.getText();
        this.createdAt = post.getCreatedAt();
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
