package in.yumtum.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.yumtum.api.cayenne.persistent.YtRestUser;
import in.yumtum.api.cayenne.persistent.YtRestaurants;
import in.yumtum.api.crypto.Password;
import in.yumtum.api.service.RestaurantService;
import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;

public class RestaurantServiceImpl implements RestaurantService {

	Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);
	
	public ResultVO createRestaurant(RestaurantVO restVO) {
		ResultVO result = checkRestaurant(restVO);
		
		if(!result.isError()){
			
			try{
			UserServiceImpl uSImpl = new UserServiceImpl();	
			ObjectContext context = DataContext.createDataContext();
			YtRestaurants newRest = context.newObject(YtRestaurants.class);
			
			newRest.setAcceptCC(restVO.getAcceptCC());
			newRest.setActive(restVO.getActive());
			newRest.setAddress(restVO.getAddress());
			newRest.setAvgCostForTwo(restVO.getAvgCostForTwo());
			newRest.setCity(restVO.getCity());
			newRest.setCusines(restVO.getCusines());
			newRest.setHasAC(restVO.getHasAC());
			newRest.setHasWifi(restVO.getHasWifi());	
			newRest.setIsVeg(restVO.getIsVeg());
			newRest.setLatitude(restVO.getLatitude());
			newRest.setLongitude(restVO.getLongitude());
			newRest.setLocality(restVO.getLocality());
			newRest.setName(restVO.getName());
			newRest.setNfsPhone(restVO.getNfsPhone());
			newRest.setPhones(restVO.getPhones());
			newRest.setToYtRestUser(uSImpl.getUser(context, restVO.getRest_createdBy()).getYtRestUserVO());
			context.commitChanges();
			}catch(Exception e){
				
				logger.error("Exception in createUser:"+e.getMessage());
				
				//System.out.println("trace: "+e);
			}
		}else{
			
		}
		
		return result;
	}

	public ResultVO deactivateRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	public RestaurantVO getRestaurantDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO updateRestaurant(RestaurantVO restVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO checkRestaurant(RestaurantVO restVO) {
		
		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		Map<String,String> params = new HashMap<String,String>();
		params.put("name", restVO.getName());
		params.put("rest_createdBy", restVO.getRest_createdBy());
		params.put("locality", restVO.getLocality());
		params.put("active", "1");
		
		Expression qualifier = Expression.fromString("name = $name and createdBy = $createdBy and locality = $locality and active = $active");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestaurants.class, qualifier);
		List restList = context.performQuery(select);
		
		if(restList.size() > 0){
			
			result.setError(true);
			result.setErrorMsg("Restaurant already exists");
			
		}else{
			result.setError(false);
		}
		
		return result;
	}
	
	public static void main(String args[]){
		
		RestaurantServiceImpl restServImpl = new RestaurantServiceImpl();
		
		RestaurantVO restVO = new RestaurantVO();
		UserServiceImpl userSImpl = new UserServiceImpl();
		
		restVO.setAcceptCC(1);
		restVO.setActive(1);
		restVO.setAddress("9th Phase");
		restVO.setAvgCostForTwo(123);
		restVO.setCity("Hyderabad");
		restVO.setCusines("1,2");
		restVO.setHasAC(1);
		restVO.setHasWifi(1);
		restVO.setLatitude("71.21");
		restVO.setLongitude("41.21");
		restVO.setLocality("KPHB");
		restVO.setName("Chandamama Multicusine Restaurant");
		restVO.setNfsPhone("9052228181");
		restVO.setPhones("9052228181,9900132174");
		restVO.setRest_createdBy("makamhareesh");
		restVO.setVeg(1);
		restServImpl.createRestaurant(restVO);
		
		
	}
	

}
