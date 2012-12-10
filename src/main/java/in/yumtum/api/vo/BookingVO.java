package in.yumtum.api.vo;

import java.util.Date;

public class BookingVO {
	

    private Integer bookingId;
    private String bookingSourceId;
    private Date bookingTime;
    private String noOfPeople;
    private Date reserveDate;
    private Integer restId;
    private Integer timing_id;
    
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingSourceId() {
		return bookingSourceId;
	}
	public void setBookingSourceId(String bookingSourceId) {
		this.bookingSourceId = bookingSourceId;
	}
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(String noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public Integer getTiming_id() {
		return timing_id;
	}
	public void setTiming_id(Integer timing_id) {
		this.timing_id = timing_id;
	}
	

}
