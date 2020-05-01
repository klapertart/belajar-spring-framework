package com.klapertart.belajarspring.validator;

import com.klapertart.belajarspring.model.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author otongsunandar
 * @since 28/04/20
 */
public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author author = (Author) target;

        if(author.getUser() == null || author.getUser().trim().isEmpty()){
            errors.rejectValue("user", "author.user.blank");
        }

        if(author.getEmail() == null || author.getEmail().trim().isEmpty()){
            errors.rejectValue("email", "author.email.blank");
        }
    }
}
