package com.progmasters.blog.validator;

import com.progmasters.blog.dto.PostFormItem;
import com.progmasters.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    private PostService postService;

    @Autowired
    public PostValidator(PostService postService) {
        this.postService = postService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PostFormItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostFormItem postFormItem = (PostFormItem) target;
        String title = postFormItem.getTitle();
        String text = postFormItem.getText();

        if (title == null || title.isEmpty()) {
            errors.rejectValue("title", "title.is-empty");
        } else if (title.length() < 3 || title.length() > 50) {
            errors.rejectValue("title", "title.invalid-length");
        }

        if (text == null || text.length() < 3 || text.length() > 1500) {
            errors.rejectValue("text", "text.invalid-length");
        }
    }
}
