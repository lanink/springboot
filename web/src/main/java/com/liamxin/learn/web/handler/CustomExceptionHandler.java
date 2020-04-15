package com.liamxin.learn.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * CustomExceptionHandler
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/15 09:16
 */

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> exception(RuntimeException e){
        Map<String, String> map = new HashMap<>();
        map.put("500", e.getMessage());
        return map;
    }

}
