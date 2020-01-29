package chris.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chris.spring.board.service.ReadArticleService;
import chris.spring.board.vo.ArticleNotFoundException;
import chris.spring.board.vo.ArticleVO;
import chris.spring.member.service.MemberService;
import chris.spring.member.vo.UpdateInfo;

public class MainFour {

	public static void main(String[] args) {
		
		String[] configLocations = new String[] {"applicationContext.xml"};
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		ReadArticleService readArticleService = context.getBean("readArticleService",ReadArticleService.class);
		
		try {
			ArticleVO article1 = readArticleService.getArticleAndIncreaseReadCount(1);
			ArticleVO article2 = readArticleService.getArticleAndIncreaseReadCount(1);
			System.out.println("article1 == article2 " + (article1 == article2));
			readArticleService.getArticleAndIncreaseReadCount(0);
		}catch(ArticleNotFoundException anfe) {
			
		}
		
		MemberService memberService = context.getBean("memberService",MemberService.class);
		memberService.update("배성직", new UpdateInfo());
		context.close();
	}

}