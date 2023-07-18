package com.snowball.boardadmin.common.exception.message;

public enum AuthExceptionMessage {
    MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다."),
    ALREADY_LOGOUT_USER("이미 로그아웃된 회원입니다."),
    NOT_AUTHORIZED_ACCESS("인증되지 않은 접근입니다."),
    NO_PERMISSION("권한이 없습니다."),
    FAIL_TOKEN_CHECK("토큰 검증에 실패했습니다."),
    TOKEN_VALID_TIME_EXPIRED("토큰의 유효기간이 만료되었습니다."),
    TOKEN_NOT_FOUND("토큰을 찾을 수 없습니다."),
    USER_NOT_FOUND("유저를 찾을 수 없습니다."),
    MISMATCH_TOKEN("토큰이 일치하지 않습니다.");
    private final String message;

    AuthExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
