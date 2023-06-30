package com.example.sample_analytics.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public class QueryUtils {
    private QueryUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void buildBooleanFilterCriteriaList(List<Criteria> criteriaList, String fieldName, String fieldValue) {
        if (StringUtils.isBlank(fieldValue)) {
            return;
        }

        if (fieldValue.equalsIgnoreCase("TRUE")) {
            criteriaList.add(Criteria.where(fieldName).is(true));
        }

        if (fieldValue.equalsIgnoreCase("FALSE")) {
            criteriaList.add(Criteria.where(fieldName).is(false));
        }
    }
}
