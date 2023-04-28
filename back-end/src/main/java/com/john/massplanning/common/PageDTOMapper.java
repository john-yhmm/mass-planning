package com.john.massplanning.common;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.function.Function;

public class PageDTOMapper<E, T> implements Function<Page<E>, PageDTO<T>> {
    @Override
    public PageDTO<T> apply(Page<E> page) {
        return new PageDTO<T>(
                new ArrayList<>(),
                page.isFirst(),
                page.isLast(),
                page.getNumber(),
                page.getSize(),
                page.getNumberOfElements(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }
}
