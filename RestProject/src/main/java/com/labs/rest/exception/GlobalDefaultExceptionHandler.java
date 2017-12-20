package com.labs.rest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Map<Class, HttpStatus> CLIENT_EXCEPTIONS = new HashMap<Class, HttpStatus>() {{
        put(IllegalStateException.class, BAD_REQUEST);
        put(UnprocessedEntityException.class, UNPROCESSABLE_ENTITY);

    }};

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handleIllegalStateException(HttpServletRequest req, IllegalStateException ex) {

        ErrorDto errorInfo;

        List<Throwable> throwableList = Arrays.stream(ex.getSuppressed()).collect(Collectors.toList());
        HttpStatus httpStatus = CLIENT_EXCEPTIONS.getOrDefault(throwableList.get(0).getClass(), BAD_REQUEST);
        errorInfo = ErrorDto.of(req.getRequestURL().toString(), httpStatus);
        throwableList.forEach(throwable -> errorInfo.addError(throwable.getMessage()));
        return new ResponseEntity<>(errorInfo, httpStatus);
    }

    @ExceptionHandler(value = {UnprocessedEntityException.class})
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorDto handleUnprocessedEntityException(HttpServletRequest req, UnprocessedEntityException ex) {
        ErrorDto errorInfo = ErrorDto.of(req.getRequestURL().toString(), UNPROCESSABLE_ENTITY);
        Stream.of(ex.getSuppressed()).forEach(throwable -> errorInfo.addError(throwable.getMessage()));
        return errorInfo;
    }

}

