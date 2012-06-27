package in.yumtum.api.service.impl;

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


	public ResultVO getRestaurantDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO getRestaurantDetails(ObjectContext context,int id) {

		ResultVO result = new ResultVO();
		
		RestaurantVO restVO = new RestaurantVO();
		
		Integer restId = id;
		YtRestaurants ytRest = new YtRestaurants();
		
		
		try{
		
		if(restId != null && restId.intValue() > 0) {
			ytRest = DataObjectUtils.objectForPK(context, YtRestaurants.class, restId);
		}
		if(ytRest != null){
			
			restVO.setAcceptCC(ytRest.getAcceptCC());
			restVO.setActive(ytRest.getActive());
			restVO.setAddress(ytRest.getAddress());
			restVO.setAvgCostForTwo(ytRest.getAvgCostForTwo());
			restVO.setCity(ytRest.getCity());
			restVO.setCusines(ytRest.getCusines());
			restVO.setHasAC(ytRest.getHasAC());
			restVO.setHasWifi(ytRest.getHasWifi());
			restVO.setLatitude(ytRest.getLatitude());
			restVO.setLongitude(ytRest.getLongitude());
			restVO.setLocality(ytRest.getLocality());
			restVO.setName(ytRest.getName());
			restVO.setNfsPhone(ytRest.getNfsPhone());
			restVO.setPhones(ytRest.getPhones());
			restVO.setRest_createdBy(ytRest.getToYtRestUser().getUserId().toString());
			restVO.setVeg(ytRest.getIsVeg());
			
			result.setError(false);
			result.setRestVO(restVO);
			result.setYtRestVO(ytRest);
			
		}else{
			
			result.setError(true);
			result.setErrorMsg("Resturant does not exist");
		}
		}
		catch(Exception e){
			result.setError(true);
			result.setErrorMsg("Exception occoured while accessing restaurant :"+e.getMessage());
		}
		
		return result;
	}

	
	public ResultVO updateRestaurant(RestaurantVO restVO) {

	    ResultVO result = new ResultVO();
	    Integer restId =  restVO.getRestId();
		YtRestaurants ytRest = new YtRestaurants();
		ObjectContext context = DataContext.createDataContext();
		
		try{
		
		if(restId != null && restId.intValue() > 0) {
			ytRest = DataObjectUtils.objectForPK(context, YtRestaurants.class, restId);
		}
		if(ytRest != null){
		
		if(!"".equals(restVO.getAcceptCC()) && restVO.getAcceptCC() != null )
		ytRest.setAcceptCC(restVO.getAcceptCC());
		
		if(!"".equals(restVO.getActive()) && restVO.getActive() != null )
			ytRest.setActive(restVO.getActive());
		
		if(!"".equals(restVO.getAddress()) && restVO.getAddress() != null )
			ytRest.setAddress(restVO.getAddress());
		
		if(!"".equals(restVO.getAvgCostForTwo()) && restVO.getAvgCostForTwo() != null )
			ytRest.setAvgCostForTwo(restVO.getAvgCostForTwo());
		
		if(!"".equals(restVO.getCity()) && restVO.getCity() != null )
			ytRest.setCity(restVO.getCity());
		
		if(!"".equals(restVO.getCusines()) && restVO.getCusines() != null )
			ytRest.setCusines(restVO.getCusines());
		
		if(!"".equals(restVO.getHasAC()) && restVO.getHasAC() != null )
			ytRest.setHasAC(restVO.getHasAC());
		
		if(!"".equals(restVO.getHasWifi()) && restVO.getHasWifi() != null )
			ytRest.setHasWifi(restVO.getHasWifi());	
		
		if(!"".equals(restVO.getIsVeg()) && restVO.getIsVeg() != null )
			ytRest.setIsVeg(restVO.getIsVeg());
		
		if(!"".equals(restVO.getLatitude()) && restVO.getLatitude() != null )
			ytRest.setLatitude(restVO.getLatitude());
		
		if(!"".equals(restVO.getLongitude()) && restVO.getLongitude() != null )
			ytRest.setLongitude(restVO.getLongitude());
		
		if(!"".equals(restVO.getLocality()) && restVO.getLocality() != null )
			ytRest.setLocality(restVO.getLocality());
		
		if(!"".equals(restVO.getName()) && restVO.getName() != null )
			ytRest.setName(restVO.getName());
		
		if(!"".equals(restVO.getNfsPhone()) && restVO.getNfsPhone() != null )
			ytRest.setNfsPhone(restVO.getNfsPhone());
		
		if(!"".equals(restVO.getPhones()) && restVO.getPhones() != null )
			ytRest.setPhones(restVO.getPhones());
		
		context.commitChanges();
		
		}}catch(Exception e){
			

			result.setError(true);
			result.setErrorMsg("Exception: User cannot be updated :"+e.getMessage());
		}
		
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
