package chris.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import chris.spring.web.user.UserVO;
@Service
@Aspect
public class AfterReturningAdvice {

//	@Pointcut("execution(* chris.spring.web..*Impl.get*(..))")
//	public void getPointcut() {
//		
//	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()",returning="returnObj")
	public void afterLog(JoinPoint joinpoint, Object returnObj) {
		String method = joinpoint.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + "로그인()");
			}
		}
		System.out.println("[사후처리] : " + method + "() 메서드 리턴값 : " + returnObj.toString());
	}
	
}
