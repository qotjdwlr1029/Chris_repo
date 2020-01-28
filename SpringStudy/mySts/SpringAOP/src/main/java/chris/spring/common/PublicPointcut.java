package chris.spring.common;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {
	
	@Pointcut("execution(public * chris.spring..*(..))")
	public void publicMethod() {
		
	}
	
}
