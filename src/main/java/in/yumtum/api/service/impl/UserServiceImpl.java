package in.yumtum.api.service.impl;

import in.yumtum.api.cayenne.persistent.YtRestUser;
import in.yumtum.api.cayenne.persistent.YtRestaurants;
import in.yumtum.api.crypto.Password;
import in.yumtum.api.service.UserService;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public ResultVO createUser(UserVO user) {
		
		ResultVO result = checkUser(user);
		
		if(!result.isError()){
			
			try{
			
				ObjectContext context = DataContext.createDataContext();
				
				YtRestUser newUser = context.newObject(YtRestUser.class);
				String hashPass = Password.getSaltedHash(user.getPassword());
				
				newUser.setName(user.getName());
				newUser.setFName(user.getfName());
				newUser.setLName(user.getlName());
				newUser.setAddress(user.getAddress());
				newUser.setLocality(user.getLocality());
				newUser.setCity(user.getCity());
				newUser.setEmail(user.getEmail());
				newUser.setPassword(hashPass);
				newUser.setPhone(user.getPhone());
				
				context.commitChanges();
				
			}catch(Exception e){
				
				logger.error("Exception in createUser:"+e.getMessage());
				
				//System.out.println("trace: "+e);
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
		
		logger.info(userList.toString());
		
		return result;
	}

	public ResultVO updateUser(UserVO user) {
		
		ObjectContext context = DataContext.createDataContext();
		
		Integer userId = user.getUserId();
		YtRestUser restUser = new YtRestUser();
		
		ResultVO result = new ResultVO();
		
		try{
		
		if(userId != null && userId.intValue() > 0) {
			restUser = DataObjectUtils.objectForPK(context, YtRestUser.class, userId);
		}
		
		if(!"".equals(user.getAddress()) || user.getAddress() != null){
			restUser.setAddress(user.getAddress());
		}else if (!"".equals(user.getCity()) || user.getCity() != null){
			restUser.setCity(user.getCity());
		}else if (!"".equals(user.getEmail()) || user.getEmail() != null){
			restUser.setEmail(user.getEmail());
		}else if (!"".equals(user.getfName()) || user.getfName() != null){
			restUser.setFName(user.getfName());
		}else if (!"".equals(user.getlName()) || user.getlName() != null){
			restUser.setLName(user.getlName());
		}else if (!"".equals(user.getLocality()) || user.getLocality() != null){
			restUser.setLocality(user.getLocality());
		}else if (!"".equals(user.getPassword()) || user.getPassword() != null){
			restUser.setPassword(user.getPassword());
		}else if (!"".equals(user.getPhone()) || user.getPhone() != null){
			restUser.setPhone(user.getPhone());
		}else if (!"".equals(user.getRestaurantsOwned()) || user.getRestaurantsOwned() != null){
			restUser.setRestaurantsOwned(user.getRestaurantsOwned());
		}
		
		context.commitChanges();
		
		result.setError(false);
		
		}catch(Exception e){

			result.setError(true);
			result.setErrorMsg("User cannot be updated");
			
		logger.error("Error while updating user info:"+e.getMessage());
			//System.out.println("Error while updating user info:"+e);
		}
		return result;
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
		params.put("name", user.getName());

		Expression qualifier = Expression.fromString("name = $name");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);

		if(userList.size() > 0){
			
			uNameExists = true;
		}
		
		return uNameExists;
	}
	
	public ResultVO validateLogin(String userName, String password) {
	
		ResultVO result = getUser(userName);
		
		if(result.isError()){
			
			return result;
			
		}else{
			String stored = result.getUserVO().getPassword();
			try {
				
				boolean validate = Password.check(password, stored);
				
				if(validate){
					
					result.setError(false);
				}else{
					result.setError(true);
					result.setErrorMsg("Login Failed");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				result.setError(false);
				result.setErrorMsg("Error while logging in.");
			
				e.printStackTrace();
			}
			
			
		}
		
		return result;
	}


	public ResultVO getUser(ObjectContext context, Integer userId) {
		
		ResultVO result = new ResultVO();
		
		UserVO user = new UserVO();

		YtRestUser ytUser = new YtRestUser();
		
		if(userId != null && userId.intValue() > 0) {
			ytUser = DataObjectUtils.objectForPK(context, YtRestUser.class, userId);
		}
		
		
		
		if(ytUser != null){
			
	     	user.setName(ytUser.getName());
	     	user.setfName(ytUser.getFName());
	     	user.setlName(ytUser.getLName());
	     	user.setAddress(ytUser.getAddress());
	     	user.setLocality(ytUser.getLocality());
	     	user.setCity(ytUser.getCity());
	     	user.setEmail(ytUser.getEmail());
	     	user.setPhone(ytUser.getPhone());
	     	user.setRestaurantsOwned(ytUser.getRestaurantsOwned());
	     	user.setUserId(ytUser.getUserId());
	     	user.setPassword(ytUser.getPassword());
	     	
	     	result.setError(false);
	     	result.setUserVO(user);
	     	result.setYtRestUserVO(ytUser);
				
	    }else{
	    	
	    	result.setError(true);
	     	result.setErrorMsg("user does not exist");
			
	    	
	    }
		return result;
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
		newUser.setEmail("hareesh.makam@oracle.com");
		newUser.setPassword("hareesh");
		newUser.setPhone("9900132174");
		
		UserServiceImpl userSImpl = new UserServiceImpl();
		
		ResultVO resultVO = userSImpl.createUser(newUser);
		
		//System.out.println(resultVO.getErrorMsg());
		/*
		ResultVO resultVO = userSImpl.validateLogin("hareesh.makam", "hareesh");
		System.out.println(resultVO.isError());
		System.out.println(resultVO.getErrorMsg());*/
	}

	public ResultVO getUser(String userName) {

		ResultVO result = new ResultVO();
		
		ObjectContext context = DataContext.createDataContext();
		Map<String,String> params = new HashMap<String,String>();
		params.put("name", userName);

		Expression qualifier = Expression.fromString("name = $name");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestUser.class, qualifier);
		List userList = context.performQuery(select);
		
		if(userList.size() == 1){
			
			YtRestUser ytUser = (YtRestUser) userList.get(0);
			UserVO user = new UserVO();
			
			user.setName(ytUser.getName());
	     	user.setfName(ytUser.getFName());
	     	user.setlName(ytUser.getLName());
	     	user.setAddress(ytUser.getAddress());
	     	user.setLocality(ytUser.getLocality());
	     	user.setCity(ytUser.getCity());
	     	user.setEmail(ytUser.getEmail());
	     	user.setPhone(ytUser.getPhone());
	     	user.setRestaurantsOwned(ytUser.getRestaurantsOwned());
	     	user.setUserId(ytUser.getUserId());
	     	user.setPassword(ytUser.getPassword());
	     	result.setError(false);
	     	result.setUserVO(user);
	     	result.setYtRestUserVO(ytUser);
			
		}else{
			result.setError(true);
			result.setErrorMsg("Invalid Login");
		}
		
		return result;
	
	}
}
