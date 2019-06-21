package com.fehead.controller;

import com.fehead.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoaxiao on 2019/6/21
 * Description: 处理Controller层抛出的自定义异常
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    // 声明自定义异常Handler
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    // 返回500错误
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String,Object> result = new HashMap<>();
        result.put("id:",ex.getId());
        result.put("message:",ex.getMessage());
        return result;
    }
}
