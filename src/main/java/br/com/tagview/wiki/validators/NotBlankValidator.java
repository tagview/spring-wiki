package br.com.tagview.wiki.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

	@Override
	public void initialize(NotBlank blankAnnotation) {}

	@Override
	public boolean isValid(String text, ConstraintValidatorContext constraintContext) {
		if (text == null) return true;
		return !text.trim().equals("");
	}

}
