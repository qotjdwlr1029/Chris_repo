package chris.spring.common;

import org.aspectj.lang.JoinPoint;

import chris.spring.member.vo.UpdateInfo;

//회원정보 수정 정보로그를 알려주는 클래스
public class UpdateMemberInfoTraceAdvice {

	public void traceReturn(JoinPoint joinpoint, boolean result, String memberId, UpdateInfo info) {
		System.out.println("[TA] 정보 수정 결과 = " + result + ", 대상회원 = " + memberId + ", 수정정보 = "+ info);
	}
	
}
