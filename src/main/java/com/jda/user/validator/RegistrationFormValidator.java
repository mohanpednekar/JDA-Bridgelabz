package com.jda.user.validator;

import com.jda.user.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> userClass) {
		return User.class.equals(userClass);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required", "Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is required");
		ValidationUtils.rejectIfEmpty(errors, "phone", "phone.required", "Phone is required");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.required", "Email is required");
		if (!(user.getUsername().matches("[a-zA-Z ]*$"))) {
			errors.rejectValue("username", "symbolsPresent", new Object[]{"'username'"}, "name can't be symbols");
		}
	}
}
