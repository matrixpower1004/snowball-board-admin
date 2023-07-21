package com.snowball.boardadmin.common.pagination;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-19
 * description    :
 */
@Getter
@ToString
public class Page<T> {

    private final List<T> content = new ArrayList<>();
    private final PageImpl pageImpl;

    @Builder
    public Page(List<T> content, PageImpl pageImpl) {
        this.content.addAll(content);
        this.pageImpl = pageImpl;
    }
}
