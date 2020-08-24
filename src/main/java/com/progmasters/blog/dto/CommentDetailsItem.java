package com.progmasters.blog.dto;

import com.progmasters.blog.domain.Comment;

public class CommentDetailsItem {
    private String author;
    private String text;

    public CommentDetailsItem(Comment comments) {
        this.author = comments.getAuthor();
        this.text = comments.getText();
    }

    public CommentDetailsItem(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
