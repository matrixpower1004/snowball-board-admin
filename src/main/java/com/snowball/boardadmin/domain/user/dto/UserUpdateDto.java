package com.snowball.boardadmin.domain.user.dto;

import com.snowball.boardadmin.common.util.UserRole;

/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
public record UserUpdateDto(
        Long id,
        UserRole userRole
) {

    public static UserUpdateDto of(
            Long id,
            UserRole userRole
    ) {
        return new UserUpdateDto(
                id,
                userRole);
    }
}
