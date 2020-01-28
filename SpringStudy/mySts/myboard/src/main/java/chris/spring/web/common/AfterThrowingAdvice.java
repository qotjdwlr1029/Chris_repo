package chris.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

//	@Pointcut("execution(* chris.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()",throwing="e")
	public void exceptionLog(JoinPoint joinpoint, Exception e) {
		String method = joinpoint.getSignature().getName();
		
		System.out.println("[예외처리] : " + method +"() 비즈니스 로직 수행 중 예외 발생 메세지 " + e.getMessage());
	}
	
}
