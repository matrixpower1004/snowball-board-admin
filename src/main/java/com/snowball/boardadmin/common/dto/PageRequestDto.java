package com.snowball.boardadmin.common.dto;

import com.snowball.boardadmin.common.pagination.Pageable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * author         : Jason Lee
 * date           : 2023-07-19
 * description    :
 */
@Getter
@RequiredArgsConstructor
public class PageRequestDto {
    private final int page;
    private final int size;
    private final String option;
    private final String keyword;

    public PageRequestDto(Pageable pageable, SearchDto searchDto) {
        this.size= pageable.getSize();
        this.page= pageable.getPage();
        this.option= searchDto.option();
        this.keyword= searchDto.keyword();
    }

    public int getOffset() {
        return (getPage() - 1) * getSize();
    }
}
