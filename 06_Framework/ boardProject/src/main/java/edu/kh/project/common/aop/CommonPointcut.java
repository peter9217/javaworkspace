package edu.kh.project.common.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
	
	@Pointcut("execution(* edu.kh.project..*Impl*.*(..))")
	public void serviceImplPointcut() {
		
	}

}
