package com.snowball.boardadmin.common.pagination;

import com.snowball.boardadmin.common.dto.SearchDto;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * author         : Jason Lee
 * date           : 2023-07-18
 * description    :
 */
public record PageImpl(
        Pageable pageable,
        int totalRecord
) {
    public static final int NAV_SIZE = 10; // 화면 하단에 보여쥴 navigation bar size

    public PageImpl {
        Assert.notNull(pageable, "pageable muusts not be null!");
        Assert.notNull(totalRecord, "totalRecord must not be null!");
    }

    // 현재 페이지가 totalPage보다 크지 않게
    public int getPageNumber() {
        return (int) Math.min(pageable.getPage(), getTotalPage());
    }

    public long getTotalPage() {
        return totalRecord / pageable.getSize() +
                (totalRecord % pageable.getSize() == 0 ? 0 : 1);
    }

    public int getBeginPage() {
        return (pageable.getPage() - 1) / NAV_SIZE * NAV_SIZE + 1;
    }

    public int getEndPage() {
        return (int) Math.min(getBeginPage() + NAV_SIZE - 1, getTotalPage());
    }

    public boolean showPrev() {
        return getBeginPage() != 1;
    }

    public boolean showNext() {
        return getEndPage() != getTotalPage();
    }

    public int getSize() {
        return pageable.getSize();
    }


    public void print() {
        System.out.println("page=" + pageable.getPage());
        System.out.print(showPrev() ? "PREV " : "");

        for (int i = getBeginPage(); i <= getEndPage(); i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext() ? " NEXT" : "");
    }
}
