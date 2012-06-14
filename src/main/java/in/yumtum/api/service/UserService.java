package in.yumtum.api.service;

import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

public interface UserService {
	
	public ResultVO createUser(UserVO user);
	public ResultVO checkUser(UserVO user);
	public ResultVO updateUser(UserVO user);
	public ResultVO validateLogin(UserVO user);
	public ResultVO forgotPassword(UserVO user);
	public boolean checkEmail(UserVO user);
	public boolean checkPhone(UserVO user);
	public boolean checkUName(UserVO user);
	
}
