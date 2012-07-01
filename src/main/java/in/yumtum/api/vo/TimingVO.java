package in.yumtum.api.vo;

public class TimingVO {
	

    private String availableSeats;
    private String reserveTime;
    private String timeOfDay;
    private Integer timingId;
    private String totalSeats;
    private Integer createdBy;
    private Integer restaurant_id;
    
	public String getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public Integer getTimingId() {
		return timingId;
	}
	public void setTimingId(Integer timingId) {
		this.timingId = timingId;
	}
	public String getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
    }
