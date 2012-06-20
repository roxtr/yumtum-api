package in.yumtum.api.vo;

import in.yumtum.api.cayenne.persistent.YtRestUser;

public class ResultVO {

	private boolean Error;
	private String ErrorMsg;
	private UserVO userVO;
	private YtRestUser ytRestUserVO;
	
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
		this.userVO = userVO;
	}

	public YtRestUser getYtRestUserVO() {
		return ytRestUserVO;
	}

	public void setYtRestUserVO(YtRestUser ytRestUserVO) {
		this.ytRestUserVO = ytRestUserVO;
	}

	

}
