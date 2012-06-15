package in.yumtum.api.service.impl;

import in.yumtum.api.cayenne.persistent.YtRestUser;
import in.yumtum.api.service.UserService;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
	
	// Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public ResultVO createUser(UserVO user) {
		
		ResultVO result = checkUser(user);
		
		if(!result.isError()){
			
			try{
			
				ObjectContext context = DataContext.createDataContext();
				
				YtRestUser newUser = context.newObject(YtRestUser.class);
				
				newUser.setName(user.getName());
				newUser.setFName(user.getfName());
				newUser.setLName(user.getlName());
				newUser.setAddress(user.getAddress());
				newUser.setLocality(user.getLocality());
				newUser.setCity(user.getCity());
				newUser.setEmail(user.getEmail());
				newUser.setPassword(user.getPassword());
				newUser.setPhone(user.getPhone());
				
				context.commitChanges();
				
			}catch(Exception e){
				
				//logger.error("Exception in createUser:"+e.getMessage());
			}
			
	
		}
		
		
		
		return result;
	}

	public ResultVO checkUser(UserVO user) {
		
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
			
			result.setError(true);
			result.setErrorMsg("User already exists");
			
		}else{
			result.setError(false);
		}
		
		System.out.println(userList);
		
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

		boolean emailExists = false;
		
		ObjectContext context = DataContext.createDataContext();
		Map<String,String> params = new HashMap<String,String>();
		params.put("email", user.getEmail());

		Expression qualifier = Expression.fromString("email = $email");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);

		if(userList.size() > 0){
			
			emailExists = true;
		}
		
		return emailExists;
		
	}

	public boolean checkPhone(UserVO user) {
		
		boolean phoneExists = false;
		
		ObjectContext context = DataContext.createDataContext();
		Map<String,String> params = new HashMap<String,String>();
		params.put("phone", user.getPhone());

		Expression qualifier = Expression.fromString("phone = $phone");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);

		if(userList.size() > 0){
			
			phoneExists = true;
		}
		
		return phoneExists;
	}

	public boolean checkUName(UserVO user) {
		
		boolean uNameExists = false;
		
		ObjectContext context = DataContext.createDataContext();
		Map<String,String> params = new HashMap<String,String>();
		params.put("phone", user.getPhone());

		Expression qualifier = Expression.fromString("phone = $phone");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);

		if(userList.size() > 0){
			
			uNameExists = true;
		}
		
		return uNameExists;
	}
	
	public ResultVO validateLogin(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public UserVO getUser(String userName) {
		
		UserVO user = new UserVO();

		ObjectContext context = DataContext.createDataContext();
		Map<String,String> params = new HashMap<String,String>();
		params.put("name", userName);

		Expression qualifier = Expression.fromString("name = $name");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);
		
		
		return null;
	}


	public static void main(String args[]){
		
		UserVO newUser = new UserVO();
		UserVO user = new UserVO();
		

		
		newUser.setName("makamhareesh");
		newUser.setfName("Hareesh");
		newUser.setlName("makam");
		newUser.setAddress("9th Phase");
		newUser.setLocality("KPHB");
		newUser.setCity("Hyderabad");
		newUser.setEmail("makamhareesh@gmail.com");
		newUser.setPassword("hareesh");
		newUser.setPhone("9052228181");
		

		UserServiceImpl userSImpl = new UserServiceImpl();
		
		userSImpl.createUser(user);
		
		user.setName("hareesh");
		user.setEmail("makamhareesh@gmail.com");
		//user.setPhone("9052228181");
		
		
		
		userSImpl.checkUser(user);
		
		
	}
}
