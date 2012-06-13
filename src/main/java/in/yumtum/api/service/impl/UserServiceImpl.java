package in.yumtum.api.service.impl;

import in.yumtum.api.service.UserService;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

public class UserServiceImpl implements UserService {

	public ResultVO createUser(UserVO user) {
		
		ResultVO result = validateUser(user);
		
		return result;
	}

	public ResultVO validateUser(UserVO user) {
		
		
		
		return null;
	}

	public ResultVO updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO forgotPassword(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

}
