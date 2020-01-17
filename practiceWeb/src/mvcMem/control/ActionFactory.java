package mvcMem.control;

import mvcMem.action.Action;
import mvcMem.action.DeleteFormAction;
import mvcMem.action.DeleteProcAction;
import mvcMem.action.IdCheckAction;
import mvcMem.action.IndexAction;
import mvcMem.action.LoginFormAction;
import mvcMem.action.LoginProcAction;
import mvcMem.action.LogoutAction;
import mvcMem.action.ModifyFormAction;
import mvcMem.action.ModifyProcAction;
import mvcMem.action.RegFormAction;
import mvcMem.action.RegProcAction;
import mvcMem.action.ZipCheckAction;

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
		}else if(cmd.equals("regForm")) {
			action = new RegFormAction();
		}else if(cmd.equals("login")) {
			action = new LoginFormAction();
		}else if(cmd.equals("idCheck")) {
			action = new IdCheckAction();
		}else if(cmd.equals("zipCheck")) {
			action = new ZipCheckAction();
		}else if(cmd.equals("regProc")) {
			action = new RegProcAction();
		}else if(cmd.equals("loginProc")) {
			action = new LoginProcAction();
		}else if(cmd.equals("modifyForm")) {
			action = new ModifyFormAction();
		}else if(cmd.equals("deleteForm")) {
			action = new DeleteFormAction();
		}else if(cmd.equals("logout")) {
			action = new LogoutAction();
		}else if(cmd.equals("modifyProc")) {
			action = new ModifyProcAction();
		}else if(cmd.equals("deleteProc")) {
			action = new DeleteProcAction();
		}
		return action;
	}

}
