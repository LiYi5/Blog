package com.ly.handler;

import com.ly.entity.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public ApiResult exceptionHandler(HttpServletRequest request, Exception e){
        logger.error("Request url:{}, Exception:{}",request.getRequestURI(),e);
        ApiResult error = new ApiResult();
        error.setData(e);
        return error;
    }

}
