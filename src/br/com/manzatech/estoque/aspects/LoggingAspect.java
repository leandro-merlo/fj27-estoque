package br.com.manzatech.estoque.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("metodosDoServico()")
	public void logaNoComeco(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		
		logger.info("Executando método: " + methodName + " da classe: " + typeName);
	}
	
	@Pointcut("execution(* br.com.manzatech.estoque.services.*.*(..))")
	public void metodosDoServico() {}
	
}
