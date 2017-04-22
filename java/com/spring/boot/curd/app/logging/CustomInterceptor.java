package com.spring.boot.curd.app.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CustomInterceptor extends HandlerInterceptorAdapter implements
		HandlerInterceptor {
	private Logger logger = LoggerFactory
			.getLogger(CustomInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		MethodParameter[] parms = method.getMethodParameters();
		for (MethodParameter parm : parms) {
			logger.info(parm.getNestedGenericParameterType().getTypeName());
		}
		logger.info("RquestedURL :" + request.getRequestURL() + "Method : "
				+ method.getMethod());
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("this is interceptor, postHandle method");
	}
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("this is interceptor, afterCompletion method");
	}
}
