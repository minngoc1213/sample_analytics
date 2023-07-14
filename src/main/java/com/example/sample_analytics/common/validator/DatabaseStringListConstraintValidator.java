package com.example.sample_analytics.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.sample_analytics.common.constant.Constant.STRING_MAX_LENGTH;

public class DatabaseStringListConstraintValidator implements ConstraintValidator<DatabaseStringListConstraint, Set<String>> {
    @Override
    public void initialize(DatabaseStringListConstraint constraint) {
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(Set<String> list, ConstraintValidatorContext context) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }

        list = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }

        return list.stream().allMatch(s -> s.length() <= STRING_MAX_LENGTH);
    }

}
