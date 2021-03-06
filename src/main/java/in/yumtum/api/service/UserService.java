package in.yumtum.api.service;

import org.apache.cayenne.ObjectContext;

import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

public interface UserService {
	
	public ResultVO createUser(UserVO user);
	public ResultVO checkUser(UserVO user);
	public ResultVO updateUser(UserVO user);
	public ResultVO getUser(String userName);
	public ResultVO getUser(ObjectContext context, Integer userId);
	public ResultVO validateLogin(String userName, String password);
	public ResultVO forgotPassword(UserVO user);
	public boolean checkEmail(UserVO user);
	public boolean checkPhone(UserVO user);
	public boolean checkUName(UserVO user);
	
}
