package in.yumtum.api.service.impl;

import in.yumtum.api.cayenne.persistent.YtRestTimings;
import in.yumtum.api.service.timingService;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.SelectQuery;

public class TimingServiceImpl implements timingService {

	public ResultVO addRestaurantTiming(TimingVO timingVO) {
		
		ResultVO result = checkRestaurantTiming(timingVO);
		
		if(!result.isError()){
			
			try{
				UserServiceImpl uSImpl = new UserServiceImpl();
				RestaurantServiceImpl rSImpl = new RestaurantServiceImpl();
				
				ObjectContext context = DataContext.createDataContext();
				
				YtRestTimings newTiming = new YtRestTimings();
				
				newTiming.setAvailableSeats(timingVO.getAvailableSeats());
				newTiming.setReserveTime(timingVO.getReserveTime());
				newTiming.setTimeOfDay(timingVO.getTimeOfDay());
				newTiming.setTotalSeats(timingVO.getTotalSeats());
				newTiming.setToYtRestaurants(rSImpl.getRestaurantDetails(context, timingVO.getRestaurant_id()).getYtRestVO());
				newTiming.setToYtRestUser(uSImpl.getUser(context, timingVO.getCreatedBy()).getYtRestUserVO());
				
				context.commitChanges();
				
				
			}catch(Exception e){
				
				result.setError(true);
				result.setErrorMsg("Exception occoured while creating restaurant :"+e.getMessage());

			}
		}
		
		return result;
	}

	public ResultVO deleteRestaurantTiming(Integer timingId) {

		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		try{

		YtRestTimings timing = (YtRestTimings) DataObjectUtils.objectForPK(context, YtRestTimings.class, timingId);
		
		if (timing != null) {
		    context.deleteObject(timing);
		    context.commitChanges();
		    
		    result.setError(false);
		}else{
			result.setError(true);
			result.setErrorMsg("This timing does not exist");
		}

		}catch(Exception e){
			result.setError(true);
			result.setErrorMsg("error in creating the timing"+e.getMessage());
			
		}
		return result;
	}

	public ResultVO updateRestaurantTiming(TimingVO timingVO) {
		

		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		try{

		YtRestTimings timing = (YtRestTimings) DataObjectUtils.objectForPK(context, YtRestTimings.class, timingVO.getTimingId());
		
		if (timing != null) {
			
			if(!"".equals(timingVO.getAvailableSeats()) && timingVO.getAvailableSeats() != null )
			      timing.setAvailableSeats(timingVO.getAvailableSeats());
			if(!"".equals(timingVO.getReserveTime()) && timingVO.getReserveTime() != null )
			      timing.setReserveTime(timingVO.getReserveTime());
			if(!"".equals(timingVO.getTimeOfDay()) && timingVO.getTimeOfDay() != null )
			      timing.setTimeOfDay(timingVO.getTimeOfDay());
			if(!"".equals(timingVO.getTotalSeats()) && timingVO.getTotalSeats() != null )
			      timing.setTotalSeats(timingVO.getTotalSeats());
			
			context.commitChanges();
			
			result.setError(false);
			result.setErrorMsg("Timing Updated");
		
		}else{
			result.setError(true);
			result.setErrorMsg("This timing does not exist");
		
		}
		}catch(Exception e){
			result.setError(true);
			result.setErrorMsg("error in updating the timing"+e.getMessage());
		
		}

		
		return result;
	}

	public ResultVO checkRestaurantTiming(TimingVO timingVO) {
		
		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		Map<String,String> params = new HashMap<String,String>();
		params.put("time_of_day", timingVO.getTimeOfDay());
		params.put("createdBy", timingVO.getCreatedBy().toString());
		params.put("restaurant_id", timingVO.getRestaurant_id().toString());
		params.put("reserve_time", timingVO.getReserveTime());
		

		Expression qualifier = Expression.fromString("time_of_day = $time_of_day and createdBy = $createdBy and restaurant_id = $restaurant_id and reserve_time = $reserve_time");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestTimings.class, qualifier);
		
		List timeList = context.performQuery(select);
		
		if(timeList.size() > 0){
			
			result.setError(true);
			result.setErrorMsg("This timing already exists");
			
		}else{
			result.setError(false);
		}
		
		return result;
	}


	public ResultVO getRestaurantTimings(int restId) {

		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		Map params = new HashMap();
		params.put("restaurant_id", restId);
		

		Expression qualifier = Expression.fromString("restaurant_id = $restaurant_id");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestTimings.class, qualifier);
		
		List<YtRestTimings> timeList = context.performQuery(select);
		
		List<TimingVO> timeVOList = new ArrayList<TimingVO>();
		
		if(timeList.size() < 1){
			
			result.setError(true);
			result.setErrorMsg("No timings for This restaurant");
			
		}else{
			result.setError(false);
			
			for(Object localObj : timeList){
				
				YtRestTimings ytRestTimings = (YtRestTimings) localObj;
				  
				  timeVOList.add(setLocalVO(ytRestTimings));
				 	
				}
				
			result.setTimeVOList(timeVOList);
		}
		
		return result;
	}
	

	public ResultVO getRestaurantTimings(ObjectContext context,int timeId) {

		ResultVO result = new ResultVO();
		
		TimingVO timingVO = new TimingVO();
		
		Integer timingId = timeId;
		YtRestTimings ytTiming = new YtRestTimings();
		
		
		try{
		
		if(timingId != null && timingId.intValue() > 0) {
			ytTiming = DataObjectUtils.objectForPK(context, YtRestTimings.class, timingId);
		}
		if(ytTiming != null){
			
			timingVO.setTimingId(ytTiming.getTimingId());
			timingVO.setAvailableSeats(ytTiming.getAvailableSeats());
			timingVO.setCreatedBy(ytTiming.getToYtRestUser().getUserId());
			timingVO.setReserveTime(ytTiming.getReserveTime());
			timingVO.setRestaurant_id(ytTiming.getToYtRestaurants().getRestId().intValue());
			timingVO.setTimeOfDay(ytTiming.getTimeOfDay());
			timingVO.setTotalSeats(ytTiming.getTotalSeats());
			result.setError(false);
			result.setTimingVO(timingVO);
			result.setYtTimeVO(ytTiming);
			
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ResultVO getRestaurantTimings(TimingVO timingVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private TimingVO setLocalVO(YtRestTimings ytTimings){
		
		TimingVO timeVO= new TimingVO();
		
		timeVO.setAvailableSeats(ytTimings.getAvailableSeats());
		timeVO.setCreatedBy(ytTimings.getToYtRestUser().getUserId());
		timeVO.setReserveTime(ytTimings.getReserveTime());
		timeVO.setRestaurant_id(ytTimings.getToYtRestaurants().getRestId());
		timeVO.setTimeOfDay(ytTimings.getTimeOfDay());
		timeVO.setTimingId(ytTimings.getTimingId());
		timeVO.setTotalSeats(ytTimings.getTotalSeats());
		
		return timeVO;
	}
	
}
