package com.snowball.snowballboardadmin.domain.admin.model;

import com.snowball.snowballboardadmin.common.util.ReportType;
import com.snowball.snowballboardadmin.common.util.ThreadType;
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
public class ReportBoard {

    private Long id;
    private Long threadId;
    private ThreadType threadType;
    private ReportType reportType;
    private Long writerId;
    private Long reporterId;
    private String reportImgUrl;
    private Timestamp reportDate;

}
