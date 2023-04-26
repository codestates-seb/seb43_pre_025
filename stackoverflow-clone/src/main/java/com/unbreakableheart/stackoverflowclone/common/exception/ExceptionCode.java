package com.unbreakableheart.stackoverflowclone.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionCode {

    MEMBER_NOT_FOUND(404, "회원을 찾을 수 없습니다."),
    MEMBER_NOT_MATCH(407, "작성자만 이용가능합니다."),
    QUESTION_NOT_FOUND(404, "질문을 찾을 수 없습니다."),
    ANSWER_NOT_FOUND(404, "답변을 찾을 수 없습니다."),
    MEMBER_EMAIL_EXISTS(406, "이미 사용중인 이메일입니다."),
    QUESTION_DELETED(406, "이미 삭제된 질문입니다."),
    PROVIDER_NOT_FOUND(404, "지원하지 않는 OAuth 입니다.");

    private final int code;
    private final String message;
}
