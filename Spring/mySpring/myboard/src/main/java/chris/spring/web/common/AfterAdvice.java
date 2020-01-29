package chris.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service 
@Aspect 
public class AfterAdvice {

	@After("PointCutCommon.allPointcut()") 
	public void finallyLog() {
		System.out.println("[����ó��] : ����Ͻ� ���� ó�� �� ������ ����");
	}
	
}