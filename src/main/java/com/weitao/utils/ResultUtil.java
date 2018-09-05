package com.weitao.utils;

import com.weitao.exception.ResultEnum;

/**
 * Created by lzr on 2018/9/4.
 */
public class ResultUtil {

    public static Result success(Object object)
    {
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success()
    {
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result error(String msg,String code)
    {
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResultEnum resultEnum)
    {
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}
