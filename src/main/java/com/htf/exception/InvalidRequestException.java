package com.htf.exception;

/**
 * Created by PC-FENG on 2017/8/11.
 */
public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidRequestException(Throwable e){
        super(e);
    }

    public InvalidRequestException(String message, Throwable e){
        super(message, e);
    }

    public InvalidRequestException(String message){
        super(message);
    }

}
