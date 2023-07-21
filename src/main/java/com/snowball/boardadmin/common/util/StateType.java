package com.snowball.boardadmin.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
@Getter
@RequiredArgsConstructor
public enum StateType {
    HIDE("숨김", true),
    SHOW("해제", false);

    private final String value;
    private final Boolean state;

    public static final Function<String, String> getValueByString = param ->
        (Boolean.parseBoolean(param)) ? StateType.HIDE.getValue() : StateType.SHOW.getValue();

    public static final Function<Boolean, String> getValueByBoolean = state ->
            state ? StateType.HIDE.getValue() : StateType.SHOW.getValue();
}
