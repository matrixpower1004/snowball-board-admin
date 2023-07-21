package com.snowball.boardadmin.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Function;

import static com.snowball.boardadmin.common.exception.message.ExceptionMessage.INVALID_REPORT_TYPE;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Getter
@RequiredArgsConstructor
public enum ReportType {
    ABUSE("욕설"),
    CALUMNY("비방"),
    LEWDNESS("음란"),
    SPAM("광고");

    private final String value;

    public static final Function<String, String> getValueByName = reportType ->
            Arrays.stream(ReportType.values())
                    .filter(r -> r.name().equalsIgnoreCase(reportType))
                    .findFirst()
                    .map(ReportType::getValue)
                    .orElseThrow(() -> new IllegalArgumentException(INVALID_REPORT_TYPE.getMessage()));
}
