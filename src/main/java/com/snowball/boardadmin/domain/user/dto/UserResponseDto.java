package com.snowball.boardadmin.domain.user.dto;

import com.snowball.boardadmin.common.util.UserRole;

import java.sql.Timestamp;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
public record UserResponseDto(
        Long id,
        String userName,
        String email,
        String nickName,
        UserRole userRole,
        Timestamp updatedAt
) {
        public static UserResponseDto of(
                Long id,
                String userName,
                String email,
                String nickName,
                UserRole userRole,
                Timestamp updatedAt
        ) {
            return new UserResponseDto(
                    id,
                    userName,
                    email,
                    nickName,
                    UserRole.valueOf(userRole.name()),
                    updatedAt);
        }
}
