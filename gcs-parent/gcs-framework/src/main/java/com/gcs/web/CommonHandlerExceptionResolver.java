package com.gcs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gcs.exception.BusinessException;
import com.gcs.result.Result;

/**
 * Common Exception Resolver
 *
 */
public class CommonHandlerExceptionResolver extends AbstractHandlerExceptionResolver {
	
	@Autowired
	private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
    	logger.error("CommonHandlerException:"+request.getRequestURI(),ex);
    	try{
    		if (ex instanceof BusinessException){
        		BusinessException e =	(BusinessException)ex;
        		fastJsonHttpMessageConverter.write(new Result(e.getErrorMsg(),e.getErrorCode()), MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
        	}else{
        		fastJsonHttpMessageConverter.write(new Result("哎呀,出错了,请稍后重试!",-1), MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
        	}
    	}catch (Exception e){}
    	return null;
    }
}
