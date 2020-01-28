package chris.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import chris.spring.web.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {

	@AfterReturning(pointcut="PointCutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("chris")) {
				System.out.println(user.getName() + "�� �α���(admin)");
			}
		}
		System.out.println("[����ó��] : "+method +"() �޼��� ���ϰ� : " + returnObj.toString());
	}
	
}
