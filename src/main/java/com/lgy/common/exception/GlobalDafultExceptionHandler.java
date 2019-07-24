package com.lgy.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalDafultExceptionHandler {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({NullPointerException.class, NumberFormatException.class})
    public ModelAndView nullPointErrorHandler(HttpServletRequest httpServletRequest, Exception e) throws Exception {
        logger.error("记录代码空指针,下次打死");
        logger.error("error:", e);
        return new ModelAndView();
    }

}
