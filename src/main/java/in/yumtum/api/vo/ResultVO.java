package in.yumtum.api.vo;

public class ResultVO {

	private boolean Error;
	private String ErrorMsg;
	
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


}
