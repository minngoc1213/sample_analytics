package com.example.sample_analytics.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({PARAMETER, TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DatabaseStringListConstraintValidator.class)
public @interface DatabaseStringListConstraint {
    String message() default "Invalid String in list";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
