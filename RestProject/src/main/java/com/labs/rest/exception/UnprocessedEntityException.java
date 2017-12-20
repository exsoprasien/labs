package com.labs.rest.exception;

public class UnprocessedEntityException extends RuntimeException {

    private String message;

    public UnprocessedEntityException(String message) {
        this.message = message;
    }

    public UnprocessedEntityException(String s, String message) {
        super(s);
        this.message = message;
    }

    public UnprocessedEntityException(String s, Throwable throwable, String message) {
        super(s, throwable);
        this.message = message;
    }

    public UnprocessedEntityException(Throwable throwable, String message) {
        super(throwable);
        this.message = message;
    }

    public UnprocessedEntityException(String s, Throwable throwable, boolean b, boolean b1, String message) {
        super(s, throwable, b, b1);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
