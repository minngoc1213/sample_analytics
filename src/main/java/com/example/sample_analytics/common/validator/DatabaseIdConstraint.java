package com.example.sample_analytics.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import java.lang.annotation.*;

import static com.example.sample_analytics.common.constant.Constant.ID_REGEX;
import static java.lang.annotation.ElementType.*;

@NotBlank
@Pattern(regexp = ID_REGEX)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@ConstraintComposition(CompositionType.AND)
public @interface DatabaseIdConstraint {
    String message() default "Invalid Id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
