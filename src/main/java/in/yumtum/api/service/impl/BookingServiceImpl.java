package in.yumtum.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import in.yumtum.api.vo.TimingVO;

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
		
		Expression qualifier = Expression.fromString("restId = $rest_id and toYtRestTimings = $timing_id and reserveDate = $reserve_date");
		
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
		
		
		String sql = "SELECT sum(no_of_people) from yt_rest_booking WHERE rest_id = (#bind($rest_id)) AND timing_id = (#bind($timing_id)) AND reserve_date = (#bind($reserve_date))";
		SQLTemplate select = new SQLTemplate(YtRestBooking.class, sql);
		
		Map parameters = new HashMap();
		parameters.put("rest_id",bookingVO.getRestId());
		parameters.put("timing_id",bookingVO.getTiming_id());
		parameters.put("reserve_date",bookingVO.getReserveDate());
		select.setParameters(parameters);

		SQLResult resultDescriptor = new SQLResult();
		resultDescriptor.addColumnResult("S");
		select.setResult(resultDescriptor);
		
		Number booked_people = (Number) DataObjectUtils.objectForQuery(context, select);
		
		if(available_seats == null){
			available_seats = 0;
		}
		if(booked_people == null){
			booked_people = 0;
		}
		
		if(available_seats.intValue() > 0 && booked_people.intValue() == 0){
			return true;
		}else if((available_seats.intValue() - booked_people.intValue()) > new Integer(bookingVO.getNoOfPeople()).intValue()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public ResultVO getBookings(String restIds){
		
		ObjectContext context = DataContext.createDataContext();

		ResultVO result = new ResultVO();

		Map params = new HashMap();
		params.put("rest_id", Arrays.asList(restIds.split(",")));
		//params.put("reserve_date", reserveDate);
		

		String sql = "SELECT * from yt_rest_booking WHERE rest_id IN (#bind($rest_id))";
		SQLTemplate select = new SQLTemplate(YtRestBooking.class, sql);
		select.setParameters(params);
		List<YtRestBooking> bookingList = context.performQuery(select);
		List<BookingVO> bookingVOList = new ArrayList<BookingVO>();
		

		if(bookingList.size() < 1){
			
			result.setError(true);
			result.setErrorMsg("No timings for This restaurant");
			
		}else{
			

			result.setError(false);
			
			for(Object localObj : bookingList){
				
				YtRestBooking ytRestBooking = (YtRestBooking) localObj;
				  
				bookingVOList.add(setLocalVO(ytRestBooking));
				 	
				}
				
			result.setBookVOList(bookingVOList);
		
		}
		
		return result;
	}
	
	
	private BookingVO setLocalVO(YtRestBooking ytRestBooking){
		
		BookingVO bookVO= new BookingVO();
		
		bookVO.setBookingId(ytRestBooking.getBookingId());
		bookVO.setBookingSourceId(ytRestBooking.getBookingSourceId());
		bookVO.setBookingTime(ytRestBooking.getBookingTime());
		bookVO.setNoOfPeople(ytRestBooking.getNoOfPeople());
		bookVO.setReserveDate(ytRestBooking.getReserveDate());
		bookVO.setRestId(ytRestBooking.getRestId());
		bookVO.setTiming_id(ytRestBooking.getToYtRestTimings().getTimingId());
		
		return bookVO;
	}
	
	
	public static void main(String args[]){
		
		BookingVO booking = new BookingVO();
		
		booking.setBookingSourceId("Online");
		booking.setBookingTime(new Date(2012, 12, 01));
		booking.setNoOfPeople("10");
		booking.setReserveDate(new Date(2012, 12, 02));
		booking.setRestId(200);
		booking.setTiming_id(200);
		
		BookingServiceImpl bookingService = new BookingServiceImpl();
		
		ResultVO result = bookingService.createBooking(booking);
		System.out.println(result.getErrorMsg());
		

	}
	
	

}
