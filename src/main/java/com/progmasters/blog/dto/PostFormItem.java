package com.progmasters.blog.dto;


public class PostFormItem {
    private String title;
    private String text;
    private String url;

    public PostFormItem(String title, String text, String url) {
        this.title = title;
        this.text = text;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }
}
