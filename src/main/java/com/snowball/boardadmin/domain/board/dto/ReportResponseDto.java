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
        Long reporterId,
        String ReporterName,
        Integer reportCount,
        Timestamp reportDate
) {
    public static ReportResponseDto of(
            ReportRequestDto reportRequestDto
    ) {
        return new ReportResponseDto(
                reportRequestDto.id(),
                reportRequestDto.postId(),
                reportRequestDto.writerId(),
                reportRequestDto.writerName(),
                reportRequestDto.userRole().getValue(),
                reportRequestDto.reporterId(),
                reportRequestDto.ReporterName(),
                reportRequestDto.reportCount(),
                reportRequestDto.reportDate()
        );
    }
}
