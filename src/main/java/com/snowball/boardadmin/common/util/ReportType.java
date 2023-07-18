package com.snowball.boardadmin.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
    SPAM("스팸"),
    AD("광고)");

    private final String value;

}
