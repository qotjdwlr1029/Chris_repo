package mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.control.ActionForward;

public interface Action {
	//ActionForward클래스를 반환하는 메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
