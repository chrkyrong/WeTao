package com.weitao.exception;

/**
 * Created by lzr on 2018/9/5.
 */
public class UserException extends RuntimeException{

    private String code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
