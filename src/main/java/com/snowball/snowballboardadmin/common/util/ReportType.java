package com.snowball.snowballboardadmin.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Getter
@AllArgsConstructor
public enum ReportType {
    ABUSE("욕설"),
    CALUMNY("비방"),
    LEWDNESS("음란"),
    SPAM("스팸"),
    AD("광고)");

    private String value;

}
