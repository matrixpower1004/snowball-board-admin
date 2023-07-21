package com.snowball.boardadmin.common.pagination;

import com.snowball.boardadmin.common.dto.SearchDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author         : Jason Lee
 * date           : 2023-07-18
 * description    :
 */
class PageImplTest {

    @Test
    void pagination_test1() {
        // Given
        Pageable pageable = Pageable.builder()
                .page(1)
                .size(10)
                .build();

        // When
        PageImpl page = new PageImpl(pageable, 110);
        page.print();

        // Then
        assertThat(page.getPageNumber()).isEqualTo(1);
        assertThat(page.totalRecord()).isEqualTo(110);
        assertThat(page.getTotalPage()).isEqualTo(11);
        assertThat(page.getBeginPage()).isEqualTo(1);
        assertThat(page.getEndPage()).isEqualTo(10);
        assertThat(page.showPrev()).isFalse();
        assertThat(page.showNext()).isTrue();
    }

    @Test
    void pagination_test2() {
        // Given
        Pageable pageable = Pageable.builder()
                .page(11)
                .size(10)
                .build();

        // When
        PageImpl page = new PageImpl(pageable, 255);
        page.print();

        // Then
        assertThat(page.getPageNumber()).isEqualTo(11);
        assertThat(page.totalRecord()).isEqualTo(255);
        assertThat(page.getTotalPage()).isEqualTo(26);
        assertThat(page.getBeginPage()).isEqualTo(11);
        assertThat(page.getEndPage()).isEqualTo(20);
        assertThat(page.showPrev()).isTrue();
        assertThat(page.showNext()).isTrue();
    }

    @Test
    void pagination_test3() {
        // Given
        Pageable pageable = Pageable.builder()
                .page(25)
                .size(10)
                .build();

        // When
        PageImpl page = new PageImpl(pageable, 255);
        page.print();

        // Then
        assertThat(page.getPageNumber()).isEqualTo(25);
        assertThat(page.totalRecord()).isEqualTo(255);
        assertThat(page.getTotalPage()).isEqualTo(26);
        assertThat(page.getBeginPage()).isEqualTo(21);
        assertThat(page.getEndPage()).isEqualTo(26);
        assertThat(page.showPrev()).isTrue();
        assertThat(page.showNext()).isFalse();
    }
}