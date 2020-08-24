package com.progmasters.blog.domain;

import com.progmasters.blog.dto.PostFormItem;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Size(min = 3, max = 1500)
    @Lob
    private String text;
    @Nullable
    @URL
    private String url;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String title, String text, String url) {
        this.title = title;
        this.text = text;
        this.url = url;
        this.createdAt = LocalDateTime.now();
    }

    public Post(PostFormItem postFormItem) {
        this.title = postFormItem.getTitle();
        this.text = postFormItem.getText();
        this.url = postFormItem.getUrl();
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
