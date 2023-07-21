package com.snowball.boardadmin.domain.board.dto;

import java.sql.Timestamp;

/**
 * author         : Jason Lee
 * date           : 2023-07-16
 * description    :
 */
public record ReportResponseDto(
        Long id,
        Long postId,
        Long writerId,
        String writerName,
        String userRole,
        String title,
        Long reporterId,
        String reporterName,
        Integer reportCount,
        Timestamp reportDate
) {
    public static ReportResponseDto from(
            ReportRequestDto reportRequestDto
    ) {
        return new ReportResponseDto(
                reportRequestDto.id(),
                reportRequestDto.postId(),
                reportRequestDto.writerId(),
                reportRequestDto.writerName(),
                reportRequestDto.userRole().getValue(),
                reportRequestDto.title(),
                reportRequestDto.reporterId(),
                reportRequestDto.reporterName(),
                reportRequestDto.reportCount(),
                reportRequestDto.reportDate()
        );
    }
}
