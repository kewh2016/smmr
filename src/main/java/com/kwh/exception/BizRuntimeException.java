package com.kwh.exception;

public class BizRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BizRuntimeException(Exception e) {
        super(e);
    }

    public BizRuntimeException(String message) {
        super(message);
    }

    public BizRuntimeException(Exception e, String message) {
        super(message, e);
    }
}
