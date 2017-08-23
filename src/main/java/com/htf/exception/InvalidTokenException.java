package com.htf.exception;

/**
 * Created by PC-FENG on 2017/8/23.
 */
public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(){
        super();
    }
    public InvalidTokenException(Throwable t){
        super(t);
    }
    public InvalidTokenException(String msg){
        super(msg);
    }
}
