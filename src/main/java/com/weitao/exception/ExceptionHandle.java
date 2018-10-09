package com.weitao.exception;

//import com.mysql.jdbc.log.LogFactory;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lzr on 2018/9/4.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e)
    {
        if(e instanceof UserException)
        {
            logger.error(e.getMessage(),e);
            UserException userException=(UserException)e;
            return ResultUtil.error(userException.getMessage(),userException.getCode());
        }
        else
        {
            logger.error(e.getMessage(),e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }
}
