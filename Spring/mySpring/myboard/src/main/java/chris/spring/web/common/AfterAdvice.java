package chris.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service 
@Aspect 
public class AfterAdvice {

	@After("PointCutCommon.allPointcut()") 
	public void finallyLog() {
		System.out.println("[사후처리] : 비즈니스 로직 처리 후 무조건 동작");
	}
	
}
