package in.yumtum.api.vo;

public class BookingVO {
	

    private Integer bookingId;
    private String bookingSourceId;
    private String bookingTime;
    private Integer noOfPeople;
    private String reserveDate;
    private Integer restId;
    private Integer timing_id;
    private String user_id;
    
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
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
