package com.snowball.boardadmin.domain.board.dto;

import com.snowball.boardadmin.common.util.UserRole;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
public record BoardStatisticsDto(
        Long id,
        String userName,
        UserRole userRole,
        Integer postCount,   // 게시글 수
        Integer commentCount, // 댓글 수
        Integer replyCount    // 대댓글 수
) {

    public static BoardStatisticsDto of(
            Long id,
            String userName,
            UserRole userRole,
            Integer postCount,
            Integer commentCount,
            Integer replyCount
    ) {
        return new BoardStatisticsDto(
                id,
                userName,
                userRole,
                postCount,
                commentCount,
                replyCount
        );
    }
}
