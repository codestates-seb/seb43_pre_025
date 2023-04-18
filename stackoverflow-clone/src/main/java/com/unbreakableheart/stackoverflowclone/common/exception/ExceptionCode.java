package com.unbreakableheart.stackoverflowclone.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionCode {
    MEMBER_NOT_FOUND(405, "회원을 찾을 수 없습니다."),
    MEMBER_EMAIL_EXISTS(406, "이미 사용중인 이메일입니다.");

    private final int code;
    private final String message;
}
