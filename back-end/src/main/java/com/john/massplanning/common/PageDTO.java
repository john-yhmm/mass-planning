package com.john.massplanning.common;

import java.io.Serializable;
import java.util.List;

public record PageDTO<T>(
        List<T> pagedList,
        boolean isFirstPage,
        boolean isLastPage,
        int currentPage,
        int maxPageSize,
        int numberOfElements,
        int totalPages,
        long totalElements
) {
}
