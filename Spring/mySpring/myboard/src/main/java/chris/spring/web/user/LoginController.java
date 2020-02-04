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
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO dao, HttpSession session) {
		System.out.println("�α��� ó��");
		if(vo.getId()==null||vo.getId().equals("")) {
			throw new IllegalAccessError("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		//1. ������� �Է� ���� ����
		//2. �����ͺ��̽� ���� ó��
		UserVO user = dao.getUser(vo);	
		//3. ȭ�� �׺���̼�
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			return "redirect:login.jsp";
		}
	}

}
