package chris.spring.common;

import java.time.format.SignStyle;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {

	public Object trace(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureString = joinpoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		
		long start = System.currentTimeMillis();
		try {
			Object result = joinpoint.proceed();
			return result;
		}finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행시간 : " + (finish- start) + "(ms)");
		}
		
	}
	
}
