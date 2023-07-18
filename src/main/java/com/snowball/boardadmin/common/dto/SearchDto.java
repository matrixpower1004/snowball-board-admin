package com.snowball.boardadmin.common.dto;

import lombok.*;


/**
 * author         : Jason Lee
 * date           : 2023-07-17
 * description    :
 */
public record SearchDto(
        String option,
        String keyword
) {
    public static SearchDto of(String option, String keyword) {
        return new SearchDto(option, keyword);
    }
}
