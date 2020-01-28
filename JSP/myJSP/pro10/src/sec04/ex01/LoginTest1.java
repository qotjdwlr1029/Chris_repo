package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginTest1
 */
//@WebServlet("/login")
public class LoginTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		out.println("<html><head>");
		out.println("<script type = 'text/javascript'>");
		//자바스크립트의 setTimeout()함수를 이용해 5초마다 재요청한다.
		out.println("setTimeout('history.go(0)',5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자 수는" + LoginImpl.total_user + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
