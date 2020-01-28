package chris.spring.web.common;

public class LogAdvice {

	public void printLog() {
		System.out.println("[로그- LogAdvice] : 비즈니스 로직 수행 전 동작");
	}
	//공통으로 적용할 관심사항
}
