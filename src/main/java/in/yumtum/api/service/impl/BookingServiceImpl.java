package in.yumtum.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.map.SQLResult;
import org.apache.cayenne.query.SQLTemplate;
import org.apache.cayenne.query.SelectQuery;

import in.yumtum.api.cayenne.persistent.YtRestBooking;
import in.yumtum.api.cayenne.persistent.YtRestTimings;
import in.yumtum.api.cayenne.persistent.YtRestaurants;
import in.yumtum.api.service.BookingService;
import in.yumtum.api.vo.BookingVO;
import in.yumtum.api.vo.ResultVO;

public class BookingServiceImpl implements BookingService {

	public ResultVO createBooking(BookingVO bookingVO) {
		
		ResultVO result = checkBooking(bookingVO);
		
		if(result.isError()){
			
			return result;
		}
		
		boolean available = checkAvailability(bookingVO);
    
		if(!available){
			result.setError(true);
			result.setErrorMsg("There are not seats available");
		}
		
		if(!result.isError() && available){  
			
			try{
				TimingServiceImpl timingImpl = new TimingServiceImpl();
				ObjectContext context = DataContext.createDataContext();
				
				YtRestBooking newBooking = new YtRestBooking();
				
				newBooking.setBookingSourceId(bookingVO.getBookingSourceId());
				newBooking.setBookingTime(bookingVO.getBookingTime());
				newBooking.setBookingUserId(bookingVO.getUser_id());
				newBooking.setNoOfPeople(bookingVO.getNoOfPeople());
				newBooking.setReserveDate(bookingVO.getReserveDate());
				newBooking.setRestId(bookingVO.getRestId());
				newBooking.setToYtRestTimings(timingImpl.getRestaurantTimings(context,bookingVO.getTiming_id()).getYtTimeVO());
				
				context.commitChanges();
				
				
			}catch(Exception e){
				
				result.setError(true);
				result.setErrorMsg("Exception occoured while creating timing :"+e.getMessage());

			}
		}
		
		return result;
		
	}

	public ResultVO updateBooking(BookingVO bookingVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO deleteBooking(Integer bookingId) {

		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		try{

		YtRestBooking booking = (YtRestBooking) DataObjectUtils.objectForPK(context, YtRestBooking.class, bookingId);
		
		if (booking != null) {
		    context.deleteObject(booking);
		    context.commitChanges();
		    
		    result.setError(false);
		}else{
			result.setError(true);
			result.setErrorMsg("This booking does not exist");
		}

		}catch(Exception e){
			result.setError(true);
			result.setErrorMsg("error in deleting the booking"+e.getMessage());
			
		}
		return result;
	
	}

	public ResultVO checkBooking(BookingVO bookingVO) {

		ObjectContext context = DataContext.createDataContext();
		
		ResultVO result = new ResultVO();

		Map params = new HashMap();
		params.put("rest_id", bookingVO.getRestId().toString());
		params.put("timing_id", bookingVO.getTiming_id().toString());
		params.put("reserve_date", bookingVO.getReserveDate());
		params.put("user_id", bookingVO.getUser_id());
		
		Expression qualifier = Expression.fromString("rest_id = $rest_id and timing_id = $timing_id and reserve_date = $reserve_date and user_id = $user_id");
		
		qualifier = qualifier.expWithParameters(params);
		
		SelectQuery select = new SelectQuery(YtRestBooking.class, qualifier);
		
		List timeList = context.performQuery(select);
		
		if(timeList.size() > 0){
			
			result.setError(true);
			result.setErrorMsg("This booking already exists");
			
		}else{
			result.setError(false);
		}
		
		return result;

	}

	public boolean checkAvailability(BookingVO bookingVO) {
		
		ObjectContext context = DataContext.createDataContext();

		Integer timingId = bookingVO.getTiming_id();
		YtRestTimings ytTime = new YtRestTimings();
		
		if(timingId != null && timingId.intValue() > 0)
		ytTime = DataObjectUtils.objectForPK(context, YtRestTimings.class, timingId);
		
		Integer available_seats = new Integer(ytTime.getAvailableSeats());
		
		
		String sql = "SELECT sum(no_of_people) from yt_rest_booking WHERE rest_id = (#bind($rest_id) AND timing_id = (#bind($timing_id) AND reserve_date = (#bind($reserve_date))";
		SQLTemplate select = new SQLTemplate(YtRestTimings.class, sql);
		
		Map parameters = new HashMap();
		parameters.put("rest_id",bookingVO.getRestId());
		parameters.put("timing_id",bookingVO.getTiming_id());
		parameters.put("reserve_date",bookingVO.getReserveDate());
		select.setParameters(parameters);

		SQLResult resultDescriptor = new SQLResult();
		resultDescriptor.addColumnResult("S");
		select.setResult(resultDescriptor);
		
		Number booked_people = (Number) DataObjectUtils.objectForQuery(context, select);
		
		if(available_seats.intValue() > 0 && booked_people.intValue() == 0){
			return true;
		}else if((available_seats.intValue() - booked_people.intValue()) > new Integer(bookingVO.getNoOfPeople()).intValue()){
			return true;
		}else{
			return false;
		}
		
	}

}
