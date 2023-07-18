package com.snowball.boardadmin.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
@Getter
@RequiredArgsConstructor
public enum StateType {
    HIDE("블라인드"),
    DELETE("삭제"),
    SHOW("해제");

    private final String value;
}