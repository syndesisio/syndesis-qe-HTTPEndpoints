package com.github.avano.springboot.http.event;

import org.apache.commons.lang3.StringUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventAspect {
	@After("@annotation(com.github.avano.springboot.http.event.Event)")
	public void storeEvent(JoinPoint joinPoint) {
		EventCollector.recordEvent(StringUtils.substringBetween(joinPoint.toShortString(), ".", "("));
	}
}
