package com.study.dawn.exception;

import com.study.dawn.common.ErrorCode;

public class NotFoundException extends RuntimeException{

    private ErrorCode errorCode;

    public NotFoundException(){
        super();
    }

    public NotFoundException(ErrorCode code, String message, Throwable throwable){
        super(message, throwable);
        this.errorCode = code;
    }

    public NotFoundException(ErrorCode code, String message){
        super(message);
        this.errorCode = code;
    }

    public NotFoundException(Throwable throwable){
        super(throwable);
    }

    public ErrorCode getErrrCode(){
        return errorCode;
    }

}
