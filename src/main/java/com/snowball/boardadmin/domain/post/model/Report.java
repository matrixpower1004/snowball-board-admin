package com.snowball.boardadmin.domain.post.model;

import com.snowball.boardadmin.common.util.ReportType;
import lombok.*;

import java.sql.Timestamp;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Report {

    private Long id;
    private Long postId;
    private ReportType reportType;
    private Long reporterId;
    private String reportImgUrl;
    private Timestamp reportDate;

}
