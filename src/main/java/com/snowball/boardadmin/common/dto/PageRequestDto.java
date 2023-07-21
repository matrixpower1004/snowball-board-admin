package com.snowball.boardadmin.common.dto;

import com.snowball.boardadmin.common.pagination.Pageable;

/**
 * author         : Jason Lee
 * date           : 2023-07-19
 * description    :
 */
public record PageRequestDto(
        int page,
        int size,
        String option,
        String keyword
) {

    public static PageRequestDto from(Pageable pageable, SearchDto searchDto) {
        return new PageRequestDto(
                pageable.getPage(),
                pageable.getSize(),
                searchDto.option(),
                searchDto.keyword()
        );
    }

    public int offset() {
        return (page() - 1) * size();
    }

}
