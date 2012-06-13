package in.yumtum.api.service;

import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

public interface UserService {
	
	public ResultVO createUser(UserVO user);
	public ResultVO validateUser(UserVO user);
	public ResultVO updateUser(UserVO user);
	public ResultVO forgotPassword(UserVO user);
	
}
