package com.example.sample_analytics.user.entity.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.CollectionUtils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseIntegerListConstraintValidator implements ConstraintValidator<DatabaseIntegerListConstraint, Set<Integer>> {
    @Override
    public void initialize(DatabaseIntegerListConstraint constraint) {
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(Set<Integer> list, ConstraintValidatorContext context) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }

        list = list.stream().filter(Objects::nonNull).collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }

        return list.stream().allMatch(s -> s > 0);
    }
}
