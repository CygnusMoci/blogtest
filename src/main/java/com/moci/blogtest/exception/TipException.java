package com.moci.blogtest.exception;

/**
 * @author moci
 * @create 2017-12-07 2:30 PM
 **/
public class TipException extends RuntimeException{
    public TipException(){}
    public TipException(String message) {
        super(message);
    }

    public TipException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipException(Throwable cause) {
        super(cause);
    }
}
