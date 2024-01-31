package com.example.spring_jwt_config.exception;

import com.example.spring_jwt_config.common.api.StatusCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final StatusCode errorCode;

    public BusinessException(StatusCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }
    public BusinessException(StatusCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public BusinessException(StatusCode errorCode, Throwable e) {
        this(errorCode);
    }
}
