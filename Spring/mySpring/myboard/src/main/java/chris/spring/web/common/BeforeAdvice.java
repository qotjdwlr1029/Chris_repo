package chris.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointCutCommon.allPointcut()")
	public void beforeLog(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		System.out.println("[����ó��] :" + method + "() �޼����� ARGS ���� :" + args[0].toString());
	}
	
}
