package com.kwh.exception;

public class BizException extends Exception{

    private static final long serialVersionUID = 1L;
    public BizException(Exception e) {
        super(e);
    }
    public BizException(String message) {
        super(message);
    }
    public BizException(Exception e,String message) {
        super(message,e);
    }
}
