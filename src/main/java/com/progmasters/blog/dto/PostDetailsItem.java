package com.progmasters.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.progmasters.blog.domain.Comment;
import com.progmasters.blog.domain.Post;

import javax.persistence.OrderBy;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostDetailsItem {
        private Long id;
        private String url;
        private String title;
        private String text;
        @JsonFormat(pattern = "YYYY.MMM dd - HH:mm")
        private LocalDateTime createdAt;
        @OrderBy(value = "createdAt desc ")
        private List<CommentDetailsItem> comments;

    public PostDetailsItem(Post post) {
        this.id = post.getId();
        this.url =post.getUrl();
        this.title = post.getTitle();
        this.text = post.getText();
        this.createdAt =post.getCreatedAt();
        this.comments = post.getComments().stream()
                .map(CommentDetailsItem::new)
                .collect(Collectors.toList());
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

    public List<CommentDetailsItem> getComments() {
        return comments;
    }
}
