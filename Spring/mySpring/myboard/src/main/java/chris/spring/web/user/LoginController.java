package chris.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chris.spring.web.user.impl.UserDAO;

@Controller
public class LoginController{
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO dao, HttpSession session) {
		System.out.println("로그인 처리");
		if(vo.getId()==null||vo.getId().equals("")) {
			throw new IllegalAccessError("아이디는 반드시 입력해야 합니다.");
		}
		//1. 사용자의 입력 정보 추출
		//2. 데이터베이스 연동 처리
		UserVO user = dao.getUser(vo);	
		//3. 화면 네비게이션
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			return "redirect:login.jsp";
		}
	}

}
