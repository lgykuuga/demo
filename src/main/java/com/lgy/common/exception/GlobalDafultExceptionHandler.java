package com.lgy.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalDafultExceptionHandler {

    @ExceptionHandler({NullPointerException.class, NumberFormatException.class})
    public ModelAndView nullPointErrorHandler(HttpServletRequest httpServletRequest, Exception e) throws Exception {
        System.out.println("记录代码空指针,下次打死");
        System.out.println(e);
        return null;
    }

}
