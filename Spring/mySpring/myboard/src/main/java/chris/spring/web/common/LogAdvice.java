package chris.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {

	@Pointcut("execution(* chris.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[�α�] : ����Ͻ� ���� ���� �� ����");
	}
	
}
