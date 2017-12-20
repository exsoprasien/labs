package com.labs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopMonitor {

	private static final Logger LOGGER = LoggerFactory.getLogger(AopMonitor.class);

	@Before("execution(* com.labs.service.*.*(..))")
	public void beforeExecution(JoinPoint joinPoint) {
		LOGGER.info("Before: " + joinPoint);
	}
	
	@After("execution(* com.labs.service.*.*(..))")
	public void afterExecution(JoinPoint joinPoint) {
		LOGGER.info("After: " + joinPoint);
	}



}