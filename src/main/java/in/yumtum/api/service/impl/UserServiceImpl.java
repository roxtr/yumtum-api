package in.yumtum.api.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;

import in.yumtum.api.cayenne.persistent.YtRestUser;
import in.yumtum.api.service.UserService;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

public class UserServiceImpl implements UserService {

	public ResultVO createUser(UserVO user) {
		
		ResultVO result = validateUser(user);
		
		
		
		return null;
	}

	public ResultVO validateUser(UserVO user) {
		
		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		Map<String,String> params = new HashMap<String,String>();
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		params.put("phone", user.getPhone());

		Expression qualifier = Expression.fromString("name = $name or email = $email or phone = $phone");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);
		
		if(userList.size() > 0){
			
			result.setIfError(true);
			result.setError("User already exists");
			
		}else{
			result.setIfError(false);
		}
		
		System.out.println(result.isIfError());
		
		return result;
	}

	public ResultVO updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO forgotPassword(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean checkEmail(UserVO user) {
		
		return false;
	}

	public boolean checkPhone(UserVO user) {
		
		return false;
	}

	public boolean checkUName(UserVO user) {
		
		return false;
	}
	
	public static void main(String args[]){
		
		UserVO user = new UserVO();
		
		user.setName("hareesh");
		user.setEmail("makamhareesh@gmail.com");
		//user.setPhone("9052228181");
		
		UserServiceImpl userSImpl = new UserServiceImpl();
		
		userSImpl.validateUser(user);
		
		
	}
}
