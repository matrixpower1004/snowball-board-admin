package com.snowball.boardadmin.domain.post.dto;

import com.snowball.boardadmin.common.util.UserRole;

import java.sql.Timestamp;

/**
 * author         : Jason Lee
 * date           : 2023-07-20
 * description    :
 */
public record PostResponseDto(
        Long id,
        Long userId,
        String userName,
        String title,
        String content,
        Boolean blindState,
        String userRole,
        Timestamp updatedAt
) {
    public PostResponseDto(Long id, Long userId, String userName, String title, String content, Boolean blindState, String userRole, Timestamp updatedAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.blindState = blindState;
        this.userRole = UserRole.getValueByName.apply(userRole);
        this.updatedAt = updatedAt;
    }

    public static PostResponseDto from(
            Long id,
            Long userId,
            String userName,
            String title,
            String content,
            String blindState,
            String userRole,
            Timestamp updatedAt
    ) {
        return new PostResponseDto(
                id,
                userId,
                userName,
                title,
                content,
                Boolean.valueOf(blindState),
                userRole,
                updatedAt
        );
    }
}
