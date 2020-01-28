package chris.spring.web.user.impl;

import chris.spring.web.user.UserService;
import chris.spring.web.user.UserVO;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
