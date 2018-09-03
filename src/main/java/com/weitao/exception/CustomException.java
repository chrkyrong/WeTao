package com.weitao.exception;

/**
 * Created by lzr on 2018/9/1.
 */
public class CustomException extends Exception{
    public String message;
    public CustomException(String message)
    {
         super(message);
         this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
