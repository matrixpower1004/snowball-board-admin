package com.snowball.boardadmin.common.pagination;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.snowball.boardadmin.common.exception.message.ExceptionMessage.INVALID_PAGE_REQUEST;

/**
 * author         : Jason Lee
 * date           : 2023-07-18
 * description    :
 */
@Getter
@Setter
@ToString
public class Pageable {

    private static final int DEFAULT_SIZE = 10;

    private int page;   // 현재 페이지 번호
    private int size;   // 한 페이지에 보여줄 목록의 갯수

    public Pageable() {
        this(1, DEFAULT_SIZE);
    }
    public Pageable(int page) {
        this(page, DEFAULT_SIZE);
    }

    @Builder
    public Pageable(int page, int size) {
        if (page < 0 || size < 1) {
            throw new IllegalArgumentException(INVALID_PAGE_REQUEST.getMessage());
        }
        this.page = page;
        this.size = size;
    }

    public int getOffset() {
        return (getPage() - 1) * getSize();
    }

}
