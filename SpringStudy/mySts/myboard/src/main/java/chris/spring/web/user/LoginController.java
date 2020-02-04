package chris.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chris.spring.web.user.impl.UserDAO;

//해당 component를 POJO방식의 클래스로 만들기 위해서 @Controller어노테이션을 붙인다.
//<context:component-scan>태그에 의해서 해당 클래스는 자동으로 빈 객체가 생성이 된다.
//하지만 해당 component는 어떤 요청이 들어와야 실행되는지 알지 못한다.
//따라서 @RequestMapping 어노테이션을 사용해서 요청정보를 지정해주어야 한다.

@Controller
public class LoginController{
	
	//@RequestMapping에서 method속성을 설정하면 get,post속성을 설정할 수 있다.
	//만일 요청정보가 일반 jsp로 끝난다면 default인 get방식으로 진행되어 
	//해당 메서드가 먼저 사용된다. 
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("apple");
		vo.setPassword("test");
		return "login.jsp";
	}
	//@Controller 어노테이션에 의해서 더 이상 Controller의 상속을 받지 않아,
	//메서드들을 자유롭게 수정할 수 있다.
	
	//login요청시에 파라미터가 있다면 post방식으로 진행되어 아래의 메서드를 실행한다.

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDao, HttpSession session) {
		System.out.println("로그인 처리");
		//1.사용자 입력 정보 추출
		//2.데이터베이스 연동 처리
		UserVO user = userDao.getUser(vo);
		//UserVO, UserDAO 객체는 각각 Command객체의 기능을 담당할 수 있으므로
		//setter메서드, 비즈니스 로직 메서드만 있다면 자동으로 처리를 하게 된다.
		//3. 화면 네비게이션
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
	}

}
