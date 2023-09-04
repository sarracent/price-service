package com.cloudx.priceservice.exception.impl;

import com.cloudx.priceservice.exception.CustomException;
import com.cloudx.priceservice.exception.ExceptionType;

import java.util.Collections;
import java.util.List;

public class DataBaseException extends RuntimeException implements CustomException {

    private static final long serialVersionUID = -1132348466005485433L;
    private final String code;
    private final String message;
    private final transient List<Object> extraInfo;

    public DataBaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.extraInfo = Collections.emptyList();
    }

    public DataBaseException(String code, String message, List<Object> extraInfo) {
        super(message);
        this.code = code;
        this.message = message;
        this.extraInfo = extraInfo;
    }

    @Override
    public ExceptionType getExceptionType() {
        return ExceptionType.DATABASE_EXCEPTION;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public List<Object> getExtraInfo() {
        return extraInfo;
    }

}