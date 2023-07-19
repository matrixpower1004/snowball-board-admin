package com.snowball.boardadmin.domain.board.dto;

import com.snowball.boardadmin.common.util.UserRole;

import java.sql.Timestamp;

/**
 * author         : Jason Lee
 * date           : 2023-07-16
 * description    :
 */
public record ReportRequestDto(
        Long id,
        Long postId,
        Long writerId,
        String writerName,
        UserRole userRole,
        String title,
        Long reporterId,
        String reporterName,
        String reportImgUrl,
        Integer reportCount,
        Timestamp reportDate
) {
    public static ReportRequestDto of(
            Long id,
            Long postId,
            Long writerId,
            String writerName,
            UserRole userRole,
            String title,
            Long reporterId,
            String reporterName,
            String reportImgUrl,
            Integer reportCount,
            Timestamp reportDate
    ) {
        return new ReportRequestDto(
                id,
                postId,
                writerId,
                writerName,
                userRole,
                title,
                reporterId,
                reporterName,
                reportImgUrl,
                reportCount,
                reportDate
        );
    }
}
