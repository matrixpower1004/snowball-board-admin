package com.snowball.snowballboardadmin.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Getter
@AllArgsConstructor
public enum UserRole {
    BLACK("블랙리스트"),
    BEGINNER("새싹회원"),
    EXPERT("우수회원"),
    ADMIN("관리자");

    private String value;
}
