package br.com.tagview.wiki.validators;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
@Documented
public @interface NotBlank {
	String message() default "{br.com.tagview.validators.notblankvalidator}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
