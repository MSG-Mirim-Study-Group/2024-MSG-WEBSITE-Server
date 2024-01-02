package com.example.msg.exception;

public class QnaException extends RuntimeException {

    private final QnaErrorCode errorCode;

    public QnaException(QnaErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public QnaErrorCode getErrorCode() {
        return errorCode;
    }
}
