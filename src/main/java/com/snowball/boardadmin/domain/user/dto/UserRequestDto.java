package com.snowball.boardadmin.domain.user.dto;

import com.snowball.boardadmin.common.util.UserRole;

/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
public record UserRequestDto(
        Long id,
        UserRole userRole
) {

    public static UserRequestDto of(
            Long id,
            UserRole userRole
    ) {
        return new UserRequestDto(
                id,
                userRole);
    }
}
