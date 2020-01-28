package chris.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

//	@Pointcut("execution(* chris.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("[BEFORE] : 비즈니스 메서드 수행 전에 처리할 내용");
		String method = joinpoint.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		Object returnObj = joinpoint.proceed();
		stopwatch.stop();
		System.out.println("[AFTER] : " + method + " 비즈니스 메서드 수행에 걸린 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
	
}
