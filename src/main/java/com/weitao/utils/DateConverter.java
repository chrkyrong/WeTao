package com.weitao.utils;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lzr on 2018/8/28.
 */
public class DateConverter implements Converter<String,Date> {

    //自定义日期转化
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            return simpleDateFormat.parse(source);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
