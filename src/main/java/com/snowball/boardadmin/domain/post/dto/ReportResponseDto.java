package com.snowball.boardadmin.domain.post.dto;

import com.snowball.boardadmin.common.util.ReportType;
import com.snowball.boardadmin.common.util.UserRole;

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
        String reportType,
        Long reporterId,
        String reporterName,
        String reportImgUrl,
        Integer reportCount,
        Timestamp reportDate
) {
    public ReportResponseDto(Long id, Long postId, Long writerId, String writerName, String userRole, String title,
                             String reportType, Long reporterId, String reporterName, String reportImgUrl,
                             Integer reportCount, Timestamp reportDate) {
        this.id = id;
        this.postId = postId;
        this.writerId = writerId;
        this.writerName = writerName;
        this.userRole = UserRole.getValueByName.apply(userRole);
        this.title = title;
        this.reportType = ReportType.getValueByName.apply(reportType);
        this.reporterId = reporterId;
        this.reporterName = reporterName;
        this.reportImgUrl = reportImgUrl;
        this.reportCount = reportCount;
        this.reportDate = reportDate;
    }

    public static ReportResponseDto from(
            Long id,
            Long postId,
            Long writerId,
            String writerName,
            UserRole userRole,
            String title,
            ReportType reportType,
            Long reporterId,
            String reporterName,
            String reportImgUrl,
            Integer reportCount,
            Timestamp reportDate
    ) {
        return new ReportResponseDto(
                id,
                postId,
                writerId,
                writerName,
                userRole.getValue(),
                title,
                reportType.getValue(),
                reporterId,
                reporterName,
                reportImgUrl,
                reportCount,
                reportDate
        );
    }
}
