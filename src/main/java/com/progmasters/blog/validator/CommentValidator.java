package com.progmasters.blog.validator;

import com.progmasters.blog.dto.CommentDetailsItem;
import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.service.CommentService;
import com.progmasters.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CommentValidator implements Validator {

    private CommentService commentService;

    @Autowired
    public CommentValidator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CommentDetailsItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CommentDetailsItem commentDetailsItem = (CommentDetailsItem) target;
        String author = commentDetailsItem.getAuthor();
        String text = commentDetailsItem.getText();

        if (author == null || author.isEmpty()) {
            errors.rejectValue("author", "author.is-empty");
        } else if (author.length() < 3 || author.length() > 50) {
            errors.rejectValue("author", "author.invalid-length");
        }

        if (text == null || text.length() < 1 || text.length() > 400) {
            errors.rejectValue("text", "comment.invalid-length");
        }
    }
}
