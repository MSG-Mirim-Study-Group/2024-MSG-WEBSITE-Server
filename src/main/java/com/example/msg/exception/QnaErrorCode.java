package com.example.msg.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QnaErrorCode {
    NO_QUESTION("질문이 입력되지 않았습니다."),
    INTERNAL_SERVER_ERROR("서버에 오류가 발생하였습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    ;

    private final String message;
}