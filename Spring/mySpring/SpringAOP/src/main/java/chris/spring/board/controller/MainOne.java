package chris.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chris.spring.board.service.WriteArticleService;
import chris.spring.board.vo.ArticleVO;
import chris.spring.member.service.MemberService;
import chris.spring.member.vo.MemberVO;

public class MainOne {

	public static void main(String[] args) {
		//기본위치라서 경로를 안씀
		String[] configLocations = new String[] {"applicationContext.xml"};
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");
		articleService.write(new ArticleVO());//글쓰기
		MemberService memberService = context.getBean("memberService",MemberService.class);//해당 클래스 타입으로 얻어올것
		memberService.regist(new MemberVO());//멤버 가입하기
		
		context.close();
	}

}
