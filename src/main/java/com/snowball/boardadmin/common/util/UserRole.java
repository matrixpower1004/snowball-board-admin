package com.snowball.boardadmin.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Function;

import static com.snowball.boardadmin.common.exception.message.ExceptionMessage.INVALID_USER_ROLE;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Getter
@RequiredArgsConstructor
public enum UserRole {
    BLACK("블랙리스트"),
    BEGINNER("새싹회원"),
    EXPERT("우수회원"),
    ADMIN("관리자");

    private final String value;

    public static final Function<String, String> getValueByName = userRole ->
            Arrays.stream(UserRole.values())
                    .filter(u -> u.name().equalsIgnoreCase(userRole))
                    .findFirst()
                    .map(UserRole::getValue)
                    .orElseThrow(() -> new IllegalArgumentException(INVALID_USER_ROLE.getMessage()));
}
