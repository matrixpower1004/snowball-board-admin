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
public enum ThreadType {
    POST("게시글"),
    COMMENT("댓글"),
    REPLY("답글");

    private String value;

}
