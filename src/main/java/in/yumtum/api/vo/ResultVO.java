package in.yumtum.api.vo;

import java.util.List;

import in.yumtum.api.cayenne.persistent.YtRestTimings;
import in.yumtum.api.cayenne.persistent.YtRestUser;
import in.yumtum.api.cayenne.persistent.YtRestaurants;

public class ResultVO {

	private boolean Error;
	private String ErrorMsg;
	private UserVO userVO;
	private YtRestUser ytRestUserVO;
	private RestaurantVO restVO;
	private YtRestaurants ytRestVO;
	private TimingVO timingVO;
	private YtRestTimings ytTimeVO;
	private List<RestaurantVO> restVOList;
	private List<TimingVO> timeVOList;
	private List<BookingVO> bookVOList;
	
	public boolean isError() {
		return Error;
	}

	public void setError(boolean error) {
		Error = error;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO user) {
		this.userVO = user;
	}

	public YtRestUser getYtRestUserVO() {
		return ytRestUserVO;
	}

	public void setYtRestUserVO(YtRestUser ytRestUserVO) {
		this.ytRestUserVO = ytRestUserVO;
	}

	public RestaurantVO getRestVO() {
		return restVO;
	}

	public void setRestVO(RestaurantVO restVO) {
		this.restVO = restVO;
	}

	public YtRestaurants getYtRestVO() {
		return ytRestVO;
	}

	public void setYtRestVO(YtRestaurants ytRestVO) {
		this.ytRestVO = ytRestVO;
	}

	public TimingVO getTimingVO() {
		return timingVO;
	}

	public void setTimingVO(TimingVO timingVO) {
		this.timingVO = timingVO;
	}

	public YtRestTimings getYtTimeVO() {
		return ytTimeVO;
	}

	public void setYtTimeVO(YtRestTimings ytTimeVO) {
		this.ytTimeVO = ytTimeVO;
	}

	public List<RestaurantVO> getRestVOList() {
		return restVOList;
	}

	public void setRestVOList(List<RestaurantVO> restVOList) {
		this.restVOList = restVOList;
	}

	public List<TimingVO> getTimeVOList() {
		return timeVOList;
	}

	public void setTimeVOList(List<TimingVO> timeVOList) {
		this.timeVOList = timeVOList;
	}

	public List<BookingVO> getBookVOList() {
		return bookVOList;
	}

	public void setBookVOList(List<BookingVO> bookVOList) {
		this.bookVOList = bookVOList;
	}

	

}
