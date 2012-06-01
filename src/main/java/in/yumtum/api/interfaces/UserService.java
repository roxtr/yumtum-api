package in.yumtum.api.interfaces;

import in.yumtum.api.vo.Result;
import in.yumtum.api.vo.User;

public interface UserService {
	
	public Result createUser(User user);
	public Result validateUser(User user);
	public Result updateUser(User user);
	public Result forgotPassword(User user);
	
}
