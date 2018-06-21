package com.stevezong.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//性能审计
@Component
@Aspect
public class AuditBean {
	@Around("within(com.stevezong.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) {
		Object obj = null;
		System.out.println(System.currentTimeMillis());
		try {
			long timeS = System.currentTimeMillis();
			obj = point.proceed();
			long timeE = System.currentTimeMillis();
			System.out.println(point.getSignature().toString());
			System.out.println(timeE-timeS);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
		
		return obj;
	}
}
