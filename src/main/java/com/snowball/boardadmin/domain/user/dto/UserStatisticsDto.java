package com.snowball.boardadmin.domain.user.dto;

import com.snowball.boardadmin.common.util.UserRole;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
public record UserStatisticsDto(
        Long id,
        String userName,
        String userRole,
        Integer postCount,   // 게시글 수
        Integer commentCount, // 댓글 수
        Integer replyCount    // 대댓글 수
) {
    public UserStatisticsDto(Long id, String userName, String userRole, Integer postCount, Integer commentCount, Integer replyCount) {
        this.id = id;
        this.userName = userName;
        this.userRole = UserRole.getValueByName.apply(userRole);
        this.postCount = postCount;
        this.commentCount = commentCount;
        this.replyCount = replyCount;
    }

    public static UserStatisticsDto from(
            Long id,
            String userName,
            UserRole userRole,
            Integer postCount,
            Integer commentCount,
            Integer replyCount
    ) {
        return new UserStatisticsDto(
                id,
                userName,
                userRole.getValue(),
                postCount,
                commentCount,
                replyCount
        );
    }
}
