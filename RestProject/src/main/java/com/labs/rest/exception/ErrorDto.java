package com.labs.rest.exception;

import com.labs.com.labs.common.Messages;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;


public class ErrorDto {

    private final String url;
    private final Integer code;
    private final String message;
    private final List<FieldErrorDto> errors = Lists.newArrayList();

    public static ErrorDto of(String url, HttpStatus code) {
        return new ErrorDto(url, code.value(), code.getReasonPhrase());
    }

    public void addError(String key) {
        errors.add(new FieldErrorDto(null, key, Messages.getDescription(key)));
    }

    public void addError(String field, String key) {
        errors.add(new FieldErrorDto(field, key, Messages.getDescription(key)));
    }

    public ErrorDto(String url, Integer code, String message) {
        this.url = url;
        this.code = code;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldErrorDto> getErrors() {
        return errors;
    }

}
