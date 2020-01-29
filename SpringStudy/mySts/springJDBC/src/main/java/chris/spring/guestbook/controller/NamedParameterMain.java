package chris.spring.guestbook.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chris.spring.guestbook.dao.NamedParamGuestMessageDao;
import chris.spring.guestbook.vo.GuestMessage;

public class NamedParameterMain {

	private GuestMessage makeGuestMessage(String guestName, String message) {
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		msg.setRegistryDate(new Date());
		return msg;
	}
	
	public static void main(String[] args) {

		String[] configLocations = new String[] {"applicationContext.xml"};
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		NamedParamGuestMessageDao dao = (NamedParamGuestMessageDao) context.getBean("namedParamGuestMessageDao");
		//main안에 makeGuestMessage메서드를 사용하기 위해서 객체 생성
		NamedParameterMain myTest = new NamedParameterMain();
		dao.insert(myTest.makeGuestMessage("배성직", "안녕하세요!"));
		dao.insert(myTest.makeGuestMessage("Chris Bae", "Hello"));
		dao.insert(myTest.makeGuestMessage("배성직", "안녕하세요!"));
		
		int count = dao.count();
		System.out.println("전체 글 수 : " + count);
		
		List<GuestMessage> list = dao.select(1, count);
		for(GuestMessage guest : list) {
			System.out.println(guest.getId() + " : " + guest.getGuestName() + " : " + 
								guest.getMessage() + " : " + guest.getRegistryDate());
		}
		
		context.close();
	}

}