package com.spring.boot.curd.app.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class LoggingAdvice {

	private ObjectMapper mapper = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.spring.boot.curd.app.service.EMSService.*(..))")
	public void getPointCut() {

	}

	@Around("getPointCut()")
	public Object logging(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		logger.info("Enter to method " + methodName + "()" + " with Request :"
				+ mapper.writeValueAsString(jp.getArgs()));
		Object args = jp.proceed();
		logger.info("Started Exceute");
		logger.info("Return :" + mapper.writeValueAsString(args));
		return args;
	}
}
