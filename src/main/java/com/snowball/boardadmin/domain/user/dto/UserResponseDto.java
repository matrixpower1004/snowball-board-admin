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
        String userRole,
        Timestamp updatedAt
) {
    public UserResponseDto(Long id, String userName, String email, String nickName, String userRole, Timestamp updatedAt) {
        this.userRole = UserRole.getValueByName.apply(userRole);
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.updatedAt = updatedAt;
    }

    public static UserResponseDto from(
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
                userRole.getValue(),
                updatedAt
        );
    }
}
