package mvc.control;

import mvc.action.Action;
import mvc.action.IndexAction;

public class ActionFactory {

	private static ActionFactory factory;
	
	private ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("index")) {		//요청한 정보를 분석(파라미터값을 받아온다.)
			action = new IndexAction();	//보낼 url과 전송방식을 설정한 객체이다.
		}
		return action;
	}
	
}
