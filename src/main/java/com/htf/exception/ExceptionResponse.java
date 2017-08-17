package com.htf.exception;

/**
 * Created by PC-FENG on 2017/8/11.
 */
public class ExceptionResponse extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExceptionResponse(Throwable e){
        super(e);
    }

    public ExceptionResponse(String message, Throwable e){
        super(message, e);
    }

    public ExceptionResponse(String message){
        super(message);
    }
}
